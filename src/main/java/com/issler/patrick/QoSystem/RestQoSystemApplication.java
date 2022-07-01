package com.issler.patrick.QoSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.issler.patrick.QoSystem.telegram.EchoBot;

@SpringBootApplication
public class RestQoSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestQoSystemApplication.class, args);
		new Thread(t1).start();
	}
	
	    private static Runnable t1 = new Runnable() {
	        public void run() {
	            try{
	              TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
	              telegramBotsApi.registerBot(new EchoBot());
	            } catch (Exception e){
	            	e.printStackTrace();
	            }
	       }
	    };

}

