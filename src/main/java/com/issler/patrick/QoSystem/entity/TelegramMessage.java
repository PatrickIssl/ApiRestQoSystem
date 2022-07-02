package com.issler.patrick.QoSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class TelegramMessage {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "message")
		private String message;
		
		@Column(name = "number")
		private String number;
		
		@Column(name = "haveResponse")
		private Boolean haveResponse;

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
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @param message the message to set
		 */
		public void setMessage(String message) {
			this.message = message;
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

		/**
		 * @return the haveResponse
		 */
		public Boolean getHaveResponse() {
			return haveResponse;
		}

		/**
		 * @param haveResponse the haveResponse to set
		 */
		public void setHaveResponse(Boolean haveResponse) {
			this.haveResponse = haveResponse;
		}
		
		
		
}
