package ru.tinkoff.edu.java.scrapper.service.jpa.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parser.LinkParser;
import link.GithubLink;
import link.ParserLink;
import link.StackOverFlowLink;
import ru.tinkoff.edu.java.scrapper.client.GitHubClient;
import ru.tinkoff.edu.java.scrapper.client.StackOverflowClient;
import ru.tinkoff.edu.java.scrapper.dto.GitHubResponse;
import ru.tinkoff.edu.java.scrapper.dto.LinkUpdate;
import ru.tinkoff.edu.java.scrapper.dto.StackOverflowItem;
import ru.tinkoff.edu.java.scrapper.exception.GitHubRequestException;
import ru.tinkoff.edu.java.scrapper.exception.StackOverflowRequestException;
import ru.tinkoff.edu.java.scrapper.model.commonDto.Link;
import ru.tinkoff.edu.java.scrapper.model.jpa.LinkEntity;
import ru.tinkoff.edu.java.scrapper.repository.jpa.JpaLinkRepository;
import ru.tinkoff.edu.java.scrapper.service.UpdateNotificationService;
import ru.tinkoff.edu.java.scrapper.service.contract.LinkUpdateService;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.List;


@Slf4j
public class JpaLinkUpdateServiceImpl implements LinkUpdateService {

    @Value("${update.delta.time}")
    private Long timeUpdateDeltaInSeconds;

    private final JpaLinkRepository linkRepository;

    private final LinkParser linkParser;

    private final GitHubClient gitHubClient;

    private final StackOverflowClient stackOverflowClient;

    private final UpdateNotificationService notificationService;

    private final int millisInSecond = 1000;

    public JpaLinkUpdateServiceImpl(
        JpaLinkRepository linkRepository,
        LinkParser linkParser,
        GitHubClient gitHubClient,
        StackOverflowClient stackOverflowClient,
        UpdateNotificationService notificationService
    ) {
        this.linkRepository = linkRepository;
        this.linkParser = linkParser;
        this.gitHubClient = gitHubClient;
        this.stackOverflowClient = stackOverflowClient;
        this.notificationService = notificationService;
    }

    @Override
    public List<Link> getOldLinks() {
        log.info("getOldLinks() method invocation in JpaLinkUpdateServiceImpl");
        Timestamp compareDate = new Timestamp(System.currentTimeMillis() - timeUpdateDeltaInSeconds * millisInSecond);
        return linkRepository.findByCheckedAtLessThanOrderByCheckedAtDesc(compareDate).stream().map(Link::fromEntity)
            .toList();
    }

    //внутренний вспомогательный метод реализации, в контракте его нет
    public List<LinkEntity> getOldEntityLinks() {
        Timestamp compareDate = new Timestamp(System.currentTimeMillis() - timeUpdateDeltaInSeconds * millisInSecond);
        return linkRepository.findByCheckedAtLessThanOrderByCheckedAtDesc(compareDate);
    }

    @Override
    @Transactional
    public void updateLinks() {
        log.info("updateLinks() method invocation in JpaLinkUpdateServiceImpl");
        List<LinkEntity> oldLinks = getOldEntityLinks();
        for (LinkEntity link : oldLinks) {
            ParseResult result = linkParser.parseUrl(link.getUrl());
            if (result instanceof GithubParseResult) {
                updateGitHubLink(link, result);
            } else if (result instanceof StackOverflowParseResult) {
                updateStackOverflowLink(link, result);
            }
        }
    }

    public void updateGitHubLink(LinkEntity link, ParseResult result) {
        try {
            boolean isUpdated = false;
            String updateDescription = "";

            GitHubResponse response = gitHubClient.fetchRepo(
                ((GithubParseResult) result).username(),
                ((GithubParseResult) result).repository()
            );

            log.info("Github response: " + response.toString());

            if (link.getGhForksCount() == null || response.forksCount() != link.getGhForksCount()) {
                isUpdated = true;
                if (link.getGhForksCount() == null) {
                    link.setGhForksCount(0);
                    isUpdated = false;
                }
                if (isUpdated && response.forksCount() < link.getGhForksCount()) {
                    updateDescription += "В репозитории уменьшилось кол-во форков\n";
                }
                if (isUpdated && response.forksCount() > link.getGhForksCount()) {
                    updateDescription += "В репозитории появились новые форки\n";
                }
                link.setGhForksCount(response.forksCount());
            }

            if (link.getGhDescription() == null || !response.description().equals(link.getGhDescription())) {
                if (link.getGhDescription() != null) {
                    isUpdated = true;
                }
                link.setGhDescription(response.description());
                updateDescription += "В репозитории изменилось описание\n";
            }

            if (link.getGhPushedAt() == null
                || response.pushedAt().toInstant().isAfter(link.getGhPushedAt().toInstant())) {
                if (link.getGhPushedAt() != null) {
                    isUpdated = true;
                }
                link.setGhPushedAt(new Timestamp(response.pushedAt().toInstant().toEpochMilli()));
                updateDescription += "В репозитории появился новый commit\n";
            }

            link.setCheckedAt(new Timestamp(System.currentTimeMillis()));

            linkRepository.save(link);

            if (isUpdated) {
                List<Long> chatsIds = linkRepository.findChatIdsByLinkId(link.getId());
                notificationService.updateLink(new LinkUpdate(
                    link.getId(),
                    link.getUrl(),
                    "Вышли обновления в репозитории:\n" + updateDescription,
                    chatsIds.toArray(new Long[0])
                ));
            }

        } catch (GitHubRequestException e) {
            log.warn(e.getMessage());
        }
    }

    public void updateStackOverflowLink(LinkEntity link, ParseResult result) {
        try {

            boolean isUpdated = false;
            String updateDescription = "";

            StackOverflowItem response =
                stackOverflowClient.fetchQuestion(((StackOverflowParseResult) result).id());

            if (response.lastEditDate() != null && (link.getSoLastEditDate() == null || response.lastEditDate()
                .isAfter(link.getSoLastEditDate().toLocalDateTime().atOffset(ZoneOffset.UTC)))) {
                if (link.getSoLastEditDate() != null) {
                    isUpdated = true;
                }
                link.setSoLastEditDate(new Timestamp(response.lastEditDate().toInstant().toEpochMilli()));
                updateDescription += "Текст вопроса был изменён\n";
            }

            if (link.getSoAnswerCount() == null || response.answerCount() != link.getSoAnswerCount()) {
                isUpdated = true;
                if (link.getSoAnswerCount() == null) {
                    link.setSoAnswerCount(0);
                    isUpdated = false;
                }
                if (isUpdated && response.answerCount() < link.getSoAnswerCount()) {
                    updateDescription += "На вопрос уменьшилось кол-во ответов\n";
                }
                if (isUpdated && response.answerCount() > link.getSoAnswerCount()) {
                    updateDescription += "На вопрос появились новые ответы\n";
                }
                link.setSoAnswerCount(response.answerCount());
            }

            link.setCheckedAt(new Timestamp(System.currentTimeMillis()));

            linkRepository.save(link);

            if (isUpdated) {
                List<Long> chatsIds = linkRepository.findChatIdsByLinkId(link.getId());
                notificationService.updateLink(new LinkUpdate(
                    link.getId(),
                    link.getUrl(),
                    "Вышли обновления в вопросе:\n" + updateDescription,
                    chatsIds.toArray(new Long[0])
                ));
            }

        } catch (StackOverflowRequestException e) {
            log.warn(e.getMessage());
        }
    }
}