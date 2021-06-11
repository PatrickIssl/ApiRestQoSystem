package com.issler.patrick.QoSystem.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import com.issler.patrick.QoSystem.entity.Pessoa;

@Component
public class EnviaMfa {

		
	public static void notificaPorEmail(String mfa , Pessoa pessoa) {
		PropriedadesEmail propriedades = new PropriedadesEmail();
		Properties props = propriedades.setPropriedades();

		Autenticacao autenticacao = new Autenticacao();
		Session session = autenticacao.autenticaEmail(props);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("QuickOrderSystems@gmail.com"));
			Address[] destinatario = InternetAddress.parse(pessoa.getEmail());
			message.setRecipients(Message.RecipientType.TO, destinatario);
			message.setSubject("Código de confirmação QoSystem");		
			message.setContent("Seu Código de confirmação do app QoSystem é "+mfa.toUpperCase(),"text/html; charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println("Não foi possivel enviar o email");
		}
	}
}
