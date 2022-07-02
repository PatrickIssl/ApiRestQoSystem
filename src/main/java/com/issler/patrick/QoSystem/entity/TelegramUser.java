package com.issler.patrick.QoSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class TelegramUser {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "name")
		private String name;
		
		@Column(name = "chatid")
		private String chatid;
		
		@Column(name = "adress")
		private String adress;
		
		@Column(name = "registrationCompleted")
		private boolean registrationCompleted;
		
		@Column(name = "passo")
		private int passo;
		
		@Column(name = "number")
		private String number;
		
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		

		/**
		 * @return the chatid
		 */
		public String getChatid() {
			return chatid;
		}

		/**
		 * @param chatid the chatid to set
		 */
		public void setChatid(String chatid) {
			this.chatid = chatid;
		}

		/**
		 * @return the passo
		 */
		public int getPasso() {
			return passo;
		}

		/**
		 * @param passo the passo to set
		 */
		public void setPasso(int passo) {
			this.passo = passo;
		}

		/**
		 * @return the adress
		 */
		public String getAdress() {
			return adress;
		}

		/**
		 * @param adress the adress to set
		 */
		public void setAdress(String adress) {
			this.adress = adress;
		}

		/**
		 * @return the registrationCompleted
		 */
		public boolean isRegistrationCompleted() {
			return registrationCompleted;
		}

		/**
		 * @param registrationCompleted the registrationCompleted to set
		 */
		public void setRegistrationCompleted(boolean registrationCompleted) {
			this.registrationCompleted = registrationCompleted;
		}

		/**
		 * @return the number
		 */
		public String getNumber() {
			return number;
		}

		/**
		 * @param number the number to set
		 */
		public void setNumber(String number) {
			this.number = number;
		}
		
		
		
}
