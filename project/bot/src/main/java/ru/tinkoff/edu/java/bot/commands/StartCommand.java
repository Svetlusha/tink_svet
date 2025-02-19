package ru.tinkoff.edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;
import ru.tinkoff.edu.java.bot.client.ScrapperClientException;
import ru.tinkoff.edu.java.bot.dto.UserAddDto;

@Component
public class StartCommand implements Command {

    private final ScrapperClient scrapperClient;

    public StartCommand(ScrapperClient scrapperClient) {
        this.scrapperClient = scrapperClient;
    }

    @Value("${tg.bot.token}")
    private String token;

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return "зарегистрировать пользователя";
    }

    @Override
    public String handle(Update update) {
        long chatId = update.message().chat().id();
        try {
            UserAddDto userAddDto = new UserAddDto(update.message().chat().username(),
                update.message().chat().firstName(),
                update.message().chat().lastName()
            );
            scrapperClient.registerChat(chatId, userAddDto);
            return "Привет! Рад познакомиться, " + update.message().chat().firstName();
        } catch (ScrapperClientException e) {

            return e.getMessage();
        }

    }
}