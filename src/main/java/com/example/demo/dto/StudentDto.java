package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 
public class StudentDto {
	 
	Integer roll;
	String name;
	String gender;
	
	
	
	public StudentDto(Integer roll, String name, String gender) {
		super();
		this.roll = roll;
		this.name = name;
		this.gender = gender;
	}
	public StudentDto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
