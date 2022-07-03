package com.issler.patrick.QoSystem.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.issler.patrick.QoSystem.entity.Resposta;
import com.issler.patrick.QoSystem.entity.TelegramUser;

public class MessageLogic {

	TelegramDataBase telegramDataBase = new TelegramDataBase();

	public Resposta newUser(TelegramUser usuario, Update update) {
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
