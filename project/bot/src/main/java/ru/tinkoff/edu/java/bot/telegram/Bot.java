package ru.tinkoff.edu.java.bot.telegram;

import java.util.EnumMap;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.slf4j.Slf4j;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import ru.tinkoff.edu.java.bot.commands.Command;
import ru.tinkoff.edu.java.bot.commands.CommandsEnum;

@Slf4j
public class Bot implements AutoCloseable {

    private final TelegramBot bot;
    private final UserMessageProcessor userMessageProcessor;
    
    Counter messagesCounter = Metrics.counter("processed_messages", "application", "bot");

    @PostConstruct
    public void init() {
        start();
    }

    public Bot(String token, EnumMap<CommandsEnum, Command> commands) {
        log.info("Создание бота... Токен: " + token);
        userMessageProcessor = new UserMessageProcessor(commands);
        bot = new TelegramBot(token);
    }

    public void start() {
        log.info("Бот запущен...");
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if (update.message() != null) {
                    bot.execute(new SendMessage(update.message().chat().id(), userMessageProcessor.process(update)));
                    messagesCounter.increment();
                }

            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    public void sendMessage(Long chatId, String msg) {
        bot.execute(new SendMessage(chatId, msg));
    }

    @Override
    public void close() throws Exception {
        bot.removeGetUpdatesListener();
    }
}