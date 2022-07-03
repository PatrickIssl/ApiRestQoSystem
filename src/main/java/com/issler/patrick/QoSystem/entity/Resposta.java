package com.issler.patrick.QoSystem.entity;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class Resposta {
	private ReplyKeyboard keyboard;
	private String text;
	/**
	 * @return the keyboard
	 */
	public ReplyKeyboard getKeyboard() {
		return keyboard;
	}
	/**
	 * @param keyboard the keyboard to set
	 */
	public void setKeyboard(ReplyKeyboard keyboard) {
		this.keyboard = keyboard;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
