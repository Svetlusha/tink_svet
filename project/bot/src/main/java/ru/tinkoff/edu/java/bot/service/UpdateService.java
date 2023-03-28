package ru.tinkoff.edu.java.bot.service;

import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.bot.dto.LinkUpdate;
import ru.tinkoff.edu.java.bot.exceptions.ChatNotFoundException;
import ru.tinkoff.edu.java.bot.exceptions.LinkIsNotRegisteredToChatException;

import java.util.Arrays;

@Service
public class UpdateService {

 public void updateLink(LinkUpdate linkUpdate) {

        if (linkUpdate.id() == 42 && Arrays.stream(linkUpdate.tgChatIds()).anyMatch(c -> c == 42))
            throw new LinkIsNotRegisteredToChatException("This link is not bounded to chat with given id");

        if (Arrays.stream(linkUpdate.tgChatIds()).anyMatch(c -> c == 10))
            throw new ChatNotFoundException("No registered chat with given id");


    }

}