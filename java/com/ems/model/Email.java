package com.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="emails")
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	private String sender;
	private String recipient;
	private String emailSubject;
	private String emailBody;
	
	


	public String getSender() {
		return sender;
	}




	public void setSender(String sender) {
		this.sender = sender;
	}




	public String getRecipient() {
		return recipient;
	}




	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}




	public String getEmailSubject() {
		return emailSubject;
	}




	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}




	public String getEmailBody() {
		return emailBody;
	}




	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	



	public Email(String sender, String recipient, String emailSubject, String emailBody) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}


	


	@Override
	public String toString() {
		return "Email [sender=" + sender + ", recipient=" + recipient + ", emailSubject=" + emailSubject
				+ ", emailBody=" + emailBody + "]";
	}




	public Email() {
		
	}
	

}
