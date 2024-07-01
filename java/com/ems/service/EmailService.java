package com.ems.service;

import java.util.List;

import com.ems.model.Email;

public interface EmailService {
	
	public Email sendEmail(Email email);
	public List<Email> getAllEmails();
	public String sendEmails(List<String> toEmails);

}
