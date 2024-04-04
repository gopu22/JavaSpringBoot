package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankingExceptionHandler {
	
	@ExceptionHandler(value = {BankingNotFoundException.class})
	public ResponseEntity<Object> handleBankingNotFoundException 
		(BankingNotFoundException bankingNotFoundException) 
	{
		BankingException bankingException = new BankingException(
				bankingNotFoundException.getMessage(),
				bankingNotFoundException.getCause(),
				HttpStatus.NOT_FOUND
		);
		
		return new ResponseEntity<>(bankingException, HttpStatus.NOT_FOUND);
		
	}

}
