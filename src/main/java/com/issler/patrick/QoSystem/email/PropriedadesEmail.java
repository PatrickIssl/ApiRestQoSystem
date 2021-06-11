package com.issler.patrick.QoSystem.email;

import java.util.Properties;

public class PropriedadesEmail {

	public Properties setPropriedades() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("SMTPSecure", "ssl");
		props.put("mail.smtp.port", "587");
		return props;
	}
}
