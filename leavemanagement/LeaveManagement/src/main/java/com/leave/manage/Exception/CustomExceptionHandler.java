package com.leave.manage.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

	@ControllerAdvice
	public class CustomExceptionHandler {

	    @ExceptionHandler(CustomException.class)
	    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}


