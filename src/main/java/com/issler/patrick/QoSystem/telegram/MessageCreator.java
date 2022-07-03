package com.issler.patrick.QoSystem.telegram;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import com.issler.patrick.QoSystem.entity.Resposta;
import com.issler.patrick.QoSystem.entity.TelegramUser;

public class MessageCreator {

	TelegramDataBase telegramDataBase = new TelegramDataBase();
	
	public Resposta message(Update update) {
		Resposta resposta = new Resposta();
		String chatId = update.getMessage().getFrom().getId().toString();
		TelegramUser usuario = telegramDataBase.findUserById(chatId);

		if (usuario == null) {
			usuario = new TelegramUser();
			resposta.setText( "Olá, sejá bem víndo ao QoSystem!"
					+ " \nVamos fazer um breve cadastro para você pedir seu lanche!"
					+ " \nPor favor informe seu nome:");
			usuario.setChatid(chatId);
			telegramDataBase.addNewUser(usuario.getChatid());
		} else if (usuario.isRegistrationCompleted()) {
			resposta = orderStarter(usuario, update);
		} else {
			resposta = newUser(usuario, update);
		}

		return resposta;
	}
	
	
	private Resposta orderStarter(TelegramUser usuario, Update update) {
		Resposta resposta = new Resposta();
		List<String> menu = new ArrayList<>();
		menu.add("teste");
		menu.add("ola");
		resposta.setKeyboard(createKeyboard(
				menu
				));
		
		resposta.setText("Olá,\n seja bem vindo,\n selecione uma das opções no menu abaixo:");
		return resposta;
	}
	
	
	private ReplyKeyboard createKeyboard(List<String> menu) {
		ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
		List<KeyboardRow> keyboardtiles = new ArrayList<>();
		for(String menuRow: menu) {
			KeyboardRow keyBoardRow = new KeyboardRow();
			KeyboardButton keyBoardButton = new KeyboardButton();
			keyBoardButton.setText(menuRow);
			keyBoardRow.add(keyBoardButton);
			keyboardtiles.add(keyBoardRow);
		}
		keyboard.setKeyboard(
				keyboardtiles
				);
		return keyboard;
	}
	
	private Resposta newUser(TelegramUser usuario, Update update) {
		Resposta resposta = new Resposta(); 
		String textoMensagem = update.getMessage().getText().toLowerCase();
		switch (usuario.getPasso()) {
		case 1:
			usuario.setName(textoMensagem);
			usuario.setPasso(2);
			telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "name", "'"+usuario.getName()+"'");
			resposta.setText("Informe seu endereço completo: \nExemplo: (Rua das palmeiras, 578, coqueiral)");
			break;
		case 2:
			usuario.setAdress(textoMensagem);
			usuario.setPasso(3);
			telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "adress", "'"+usuario.getAdress()+"'");
			resposta.setText("Informe seu numero de telefone:");
			break;
		case 3:
			usuario.setNumber(textoMensagem);
			usuario.setPasso(0);
			usuario.setRegistrationCompleted(true);
			telegramDataBase.editUserById(usuario.getId().toString(), "number", "'"+usuario.getNumber()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "registration_completed", "True");
			resposta.setText("Cadastro concluido com sucesso!");
			break;
		}
		
		return resposta;
	}
	


}
