package com.issler.patrick.QoSystem.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.issler.patrick.QoSystem.entity.Resposta;
import com.issler.patrick.QoSystem.entity.TelegramUser;

public class MessageCreator {

	TelegramDataBase telegramDataBase = new TelegramDataBase();

	public Resposta message(Update update) {
		String chatId = update.getMessage().getFrom().getId().toString();
		TelegramUser usuario = telegramDataBase.findUserById(chatId);
		Resposta resposta = new Resposta();
		MessageLogic messageLogic = new MessageLogic();
		if (usuario == null) {
			usuario = new TelegramUser();
			resposta.setText(
					"Olá, sejá bem víndo ao QoSystem!" + " \nVamos fazer um breve cadastro para você pedir seu lanche!"
							+ " \nPor favor informe seu nome:");
			usuario.setChatid(chatId);
			telegramDataBase.addNewUser(usuario.getChatid());
			return resposta;
		} else if (usuario.isRegistrationCompleted()) {
			return orderStarter(usuario, update);
		} else {
			return messageLogic.newUser(usuario, update);
		}

	}

	private Resposta orderStarter(TelegramUser usuario, Update update) {
		TelegramMenu telegramMenu = new TelegramMenu();
		Resposta resposta = new Resposta();

		switch (update.getMessage().getText()) {
			case "Iniciar Pedido":
				usuario.setPasso(1);
				break;
			case "Verificar Pedido":
				usuario.setPasso(2);
				break;
			case "Cancelar Pedido":
				usuario.setPasso(3);
				break;
			case "Editar informações do perfil":
					usuario.setPasso(4);
				break;
		}
		telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");

		switch (usuario.getPasso()) {
		case 0:
			resposta = telegramMenu.menuZero(usuario, update);
			break;
		case 4:
			resposta = telegramMenu.menuFour(usuario, update);
			break;
		}

		return resposta;
	}

}
