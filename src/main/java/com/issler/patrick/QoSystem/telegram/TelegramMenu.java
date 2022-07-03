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

public class TelegramMenu {

	MessageLogic messageLogic = new MessageLogic();

	public Resposta menuZero(TelegramUser usuario, Update update) {
		Resposta resposta = new Resposta();
		List<String> menu = new ArrayList<>();
		menu.add("Iniciar Pedido");
		menu.add("Verificar Pedido");
		menu.add("Cancelar Pedido");
		menu.add("Editar informações do perfil");
		resposta.setKeyboard(createKeyboard(
				menu
				));
		resposta.setText("Olá,\n seja bem vindo,\n selecione uma das opções no menu abaixo:\n"
				+ "1- Iniciar pedido\n"
				+ "2- Verificar pedido\n"
				+ "3- Cancelar pedido\n"
				+ "4- Editar informações do perfil");
		return resposta;
	}
	
	public Resposta menuFour(TelegramUser usuario, Update update) {
		Resposta resposta = new Resposta();
		List<String> menu = new ArrayList<>();
		resposta.setText("Olá,selecione qual das opções abaixo você deseja editar:\n"
				+ "1- Nome :"+usuario.getName()+"\n"
				+ "2- Telefone:"+usuario.getNumber()+"\n"
				+ "3- Endereco: "+usuario.getAdress()+"\n"
				+ "4- Cancelar");
		menu.add("Nome");
		menu.add("Telefone");
		menu.add("Endeço");
		menu.add("Cancelar");
		
		resposta.setKeyboard(createKeyboard(
				menu
				));
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
		keyboard.setOneTimeKeyboard(true);
		return keyboard;
	}
	
	
}
