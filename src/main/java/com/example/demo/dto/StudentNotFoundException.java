package com.example.demo.dto;

public class StudentNotFoundException extends RuntimeException {

	 
	public StudentNotFoundException(String err)
	{
		super(err);
	}
}
