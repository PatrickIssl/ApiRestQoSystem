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

	TelegramDataBase telegramDataBase = new TelegramDataBase();
	MessageLogic messageLogic = new MessageLogic();

	public Resposta menuZero(TelegramUser usuario, Update update) {
		Resposta resposta = new Resposta();
		List<String> menu = new ArrayList<>();
		menu.add("Iniciar Pedido");
		menu.add("Verificar Pedido");
		menu.add("Cancelar Pedido");
		menu.add("Editar informações do perfil");
		resposta.setKeyboard(createKeyboard(menu));
		resposta.setText("Olá "+usuario.getName()+",\nseja bem vindo,\nselecione uma das opções no menu abaixo:\n" + "1- Iniciar pedido\n"
				+ "2- Verificar pedido\n" + "3- Cancelar pedido\n" + "4- Editar informações do perfil");
		return resposta;
	}

	public Resposta menuFour(TelegramUser usuario, Update update) {
		Resposta resposta = new Resposta();
		List<String> menu = new ArrayList<>();

		switch (update.getMessage().getText()) {
			case "Nome":
				resposta.setText("Olá "+usuario.getName()+", Informe o novo nome para realizar a atualização:");
				telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'41'");
				telegramDataBase.editUserById(usuario.getId().toString(), "registration_completed", "False");
			break;
			case "Telefone":
				resposta.setText("Olá "+usuario.getName()+", Informe o novo telefone para realizar a atualização:");
				telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'42'");
				telegramDataBase.editUserById(usuario.getId().toString(), "registration_completed", "False");
			break;
			case "Endereço":
				resposta.setText("Olá "+usuario.getName()+", Informe o novo endereço para realizar a atualização:");
				telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'43'");
				telegramDataBase.editUserById(usuario.getId().toString(), "registration_completed", "False");
			break;
			case "Cancelar":
				telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'0'");
				resposta = menuZero(usuario, update);
			break;
	
			default:
				resposta.setText("Olá,selecione qual das opções abaixo você deseja editar:\n" + "1- Nome: "
						+ usuario.getName() + "\n" + "2- Telefone: " + usuario.getNumber() + "\n" + "3- Endereco: "
						+ usuario.getAdress() + "\n" + "4- Cancelar");
				menu.add("Nome");
				menu.add("Telefone");
				menu.add("Endereço");
				menu.add("Cancelar");
				resposta.setKeyboard(createKeyboard(menu));
			break;
		}

		return resposta;
	}

	private ReplyKeyboard createKeyboard(List<String> menu) {
		ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
		List<KeyboardRow> keyboardtiles = new ArrayList<>();
		for (String menuRow : menu) {
			KeyboardRow keyBoardRow = new KeyboardRow();
			KeyboardButton keyBoardButton = new KeyboardButton();
			keyBoardButton.setText(menuRow);
			keyBoardRow.add(keyBoardButton);
			keyboardtiles.add(keyBoardRow);
		}
		keyboard.setKeyboard(keyboardtiles);
		keyboard.setOneTimeKeyboard(true);
		return keyboard;
	}

}
