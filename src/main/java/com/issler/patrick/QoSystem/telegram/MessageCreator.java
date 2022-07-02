package com.issler.patrick.QoSystem.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.issler.patrick.QoSystem.entity.TelegramUser;

public class MessageCreator {

	TelegramDataBase telegramDataBase = new TelegramDataBase();
	
	public String message(Update update) {
		String resposta = "";
		String chatId = update.getMessage().getFrom().getId().toString();
		TelegramUser usuario = telegramDataBase.findUserById(chatId);

		if (usuario == null) {
			usuario = new TelegramUser();
			resposta = "Olá, sejá bem víndo ao QoSystem!"
					+ " \nVamos fazer um breve cadastro para você pedir seu lanche!"
					+ " \nPor favor informe seu nome:";
			usuario.setChatid(chatId);
			telegramDataBase.addNewUser(usuario.getChatid());
		} else if (usuario.isRegistrationCompleted()) {
			resposta = "Olá, seja bem víndo.";
		} else {
			resposta = newUser(usuario, update);
		}

		return resposta;
	}

	
	private String newUser(TelegramUser usuario, Update update) {
		String resposta = ""; 
		String textoMensagem = update.getMessage().getText().toLowerCase();
		switch (usuario.getPasso()) {
		case 1:
			usuario.setName(textoMensagem);
			usuario.setPasso(2);
			telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "name", "'"+usuario.getName()+"'");
			resposta = "Informe seu endereço completo: \nExemplo: (Rua das palmeiras, 578, coqueiral)";
			break;
		case 2:
			usuario.setAdress(textoMensagem);
			usuario.setPasso(3);
			telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "adress", "'"+usuario.getAdress()+"'");
			resposta = "Informe seu numero de telefone:";
			break;
		case 3:
			usuario.setNumber(textoMensagem);
			usuario.setPasso(0);
			usuario.setRegistrationCompleted(true);
			telegramDataBase.editUserById(usuario.getId().toString(), "number", "'"+usuario.getNumber()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "passo", "'"+usuario.getPasso()+"'");
			telegramDataBase.editUserById(usuario.getId().toString(), "registration_completed", "True");
			resposta = "Cadastro concluido com sucesso!";
			break;
		}
		
		return resposta;
	}
	


}
