package com.web.application.callexternalapi;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {


	@ExceptionHandler
	public String dataNotFound(Exception dne) {
		
		return "DataNotFountException success";
	}
}
