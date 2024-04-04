package com.example.demo.exception;

public class BankingNotFoundException extends RuntimeException {
	
	// Constructors
	public BankingNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BankingNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
