package com.ems.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.customexception.BusinessException;
import com.ems.model.Email;
import com.ems.model.Vendor;
import com.ems.repository.EmailRespository;
import com.ems.repository.VendorRepository;
import com.ems.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private EmailRespository emailRespository;
	
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Email sendEmail(Email email) {
		if(email.getRecipient()=="") {
			throw new BusinessException("Please Enter Reciver Email");
		}else if(email.getSender()=="") {
			throw new BusinessException("Please Enter Sender Email");
		}else if(email.getEmailSubject()=="") {
			throw new BusinessException("Please Enter Subject");
		}else if(email.getEmailBody()=="") {
			throw new BusinessException("Please Enter Email Body");
		}else {
			String subject = "Sending payments to vendor"+email.getRecipient()+" at upi "+email.getRecipient();
			email.setEmailBody(subject);
			return this.emailRespository.save(email);
		}
			
		
	}

	@Override
	public List<Email> getAllEmails() {
		try {
			List<Email> allEmails = this.emailRespository.findAll();
			return allEmails;
		}catch(Exception e ) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public String sendEmails(List<String> toEmails) {
		
		
	
		try {
			
			
		for (String toEmail : toEmails) {
			Email email = new Email();
			email.setEmailSubject("Payment");
			email.setSender("Admin@credmarg.com");
			
			Vendor vendorDetails = this.vendorRepository.findByVendorEmail(toEmail);
			if(vendorDetails==null) {
				throw new BusinessException("Vendor details Not Found");
			}
			email.setRecipient(toEmail);
			String subject = "Sending payments to vendor "+vendorDetails.getVendorName()+" at upi "+email.getRecipient();
			email.setEmailBody(subject);
			this.emailRespository.save(email);
			
			
		}
		}catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return "Email sent sucessfully";
		
	}

}
