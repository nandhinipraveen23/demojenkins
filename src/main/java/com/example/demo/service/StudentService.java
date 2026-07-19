package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentNotFoundException;

public interface StudentService {

	
	public StudentDto insertStudent(StudentDto studentDto);
	
	public List<StudentDto> getAllStudent();
	
	public StudentDto getRoll(Integer roll) ;
	
	public void deleteStudent(Integer roll) ;
	
	public StudentDto editStudent(StudentDto studentDto);
}
