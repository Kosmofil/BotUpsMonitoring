package controllers;

import models.BotSource;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;
import static models.ComandsList.*;
import java.io.IOException;
import static models.BotSource.*;
public class ApcBot extends TelegramLongPollingBot {

    public static void runBot() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ApcBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return getBOTUSERNAME();
    }

    @Override
    public String getBotToken() {
        return getBOTTOKEN();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText() || message.hasLocation()) {
                    IncominMessage(message);
                }
            }
        } catch (Exception e) {
            BotLogger.error("error", e);
        }

    }

    public void IncominMessage(Message message) throws TelegramApiException, IOException {

        SendMessage sendMessageReq = null;

        switch (message.getText()) {
            case COMMAND_HELP:
                sendMessageReq = send(message, DEFAULT_TEXT);
                break;
            case DEFAULT_TEXT:
                sendMessageReq = send(message, DEFAULT_TEXT);
                default:
                    sendMessageReq = send(message, getBotTestAnswer());
        }
        //TODO
        sendMessage(sendMessageReq);
    }

    private static SendMessage configSend(Message message) {
        SendMessage sendingMessage = new SendMessage();
        //TODO
        sendingMessage.enableMarkdown(true);
        sendingMessage.setChatId(message.getChatId().toString());
        return sendingMessage;
    }

    private SendMessage send(Message message, String command) throws TelegramApiRequestException, IOException {

        return configSend(message).setText(command);

    }

}
