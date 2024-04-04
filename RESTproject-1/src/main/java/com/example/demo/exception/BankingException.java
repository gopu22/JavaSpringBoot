package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BankingException {
	
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpstatus;
	
	// constructors
	public BankingException(String message, Throwable throwable, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
	}
	
	// getters and setters
	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	
}
