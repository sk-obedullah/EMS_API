package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.customexception.BusinessException;
import com.ems.customexception.ControllerException;
import com.ems.model.Email;
import com.ems.model.Vendor;
import com.ems.service.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody Email email) {
		
		try {
			Email sentEmail = this.emailService.sendEmail(email);
			return new ResponseEntity<Email>(sentEmail, HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (ControllerException e) {
			ControllerException ce = new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allEmails")
	public ResponseEntity<?> getAllEmails() {
		try {
			List<Email> emailDetails = this.emailService.getAllEmails();
			return new ResponseEntity<>(emailDetails,HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (ControllerException e) {
			ControllerException ce = new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping("/sendEmails")
	public ResponseEntity<?> sendEmails(@RequestBody List<String> emailList) {
		try {
			System.out.println("Email start");
			String response = this.emailService.sendEmails(emailList);
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (ControllerException e) {
			ControllerException ce = new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);

		}
	}

}
