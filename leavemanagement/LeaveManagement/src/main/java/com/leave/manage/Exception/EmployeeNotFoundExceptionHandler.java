package com.leave.manage.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class EmployeeNotFoundExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleLeaveRequestNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
