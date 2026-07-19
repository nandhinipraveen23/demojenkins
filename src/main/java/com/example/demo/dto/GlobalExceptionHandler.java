package com.example.demo.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseMsg> handleStudentException(StudentNotFoundException ex){
		
		
		ResponseMsg msg=new ResponseMsg(ex.getMessage());
		return  ResponseEntity.badRequest().body(msg);
	}



}
