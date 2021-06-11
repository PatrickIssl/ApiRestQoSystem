package com.issler.patrick.QoSystem.email;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Autenticacao {

	protected Session autenticaEmail(Properties props) {
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("QuickOrderSystems@gmail.com", "Ka3031no&");
				}
			});
		session.setDebug(true);
		return session;
	}
}
