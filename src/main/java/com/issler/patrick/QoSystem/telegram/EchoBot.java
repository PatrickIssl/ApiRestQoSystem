package com.issler.patrick.QoSystem.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.issler.patrick.QoSystem.entity.BotData;
import com.issler.patrick.QoSystem.entity.Resposta;

public class EchoBot extends TelegramLongPollingBot {
	
    @Override
    public String getBotUsername() {
        return BotData.BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return BotData.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
        	
            SendMessage mensagem = responder(update);
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    
    private SendMessage responder(Update update) {
    	MessageCreator messageCreator = new MessageCreator();
        String chatId = update.getMessage().getChatId().toString();
        Resposta resposta = messageCreator.message(update);
        if(resposta.getKeyboard() != null) {
            return SendMessage.builder()
                    .text(resposta.getText())
                    .chatId(chatId)
                    .replyMarkup(resposta.getKeyboard())
                    .build();
        }else {
            return SendMessage.builder()
                    .text(resposta.getText())
                    .chatId(chatId)
                    .build();
        }
    }


  

}