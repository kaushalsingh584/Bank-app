package com.monocept.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountBalanceHandler  {

	@ExceptionHandler
	public ResponseEntity<AccountBalanceResponse> handleException(NotSufficentBalanceException e)
	{
		AccountBalanceResponse response=new AccountBalanceResponse();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(e.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
}
