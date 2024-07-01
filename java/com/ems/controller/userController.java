package com.ems.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.UserDetails;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class userController {
	
	@PostMapping("/login")
	public String getUserRole(@Validated @RequestBody UserDetails userDetails) {
		
		String name = "Admin";
		String pass = "Admin";
		System.out.println(userDetails);
		
		if(name.equals(userDetails.getUserName()) && pass.equals(userDetails.getPassword())) {
			return "Success";
		}else {
			return "username and password is wrong";
		}
		
	}
	

}
