package com.ems.customexception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BusinessException [message=" + message + "]";
	}
	

	public BusinessException(String message) {
		super();
		this.message = message;
	}

	public BusinessException() {
		
	}
}
