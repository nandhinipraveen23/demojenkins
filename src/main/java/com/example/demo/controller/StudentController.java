package com.example.demo.controller;

import java.util.List;

import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseMsg;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/new")
	public ResponseEntity<StudentDto> addStu(@RequestBody StudentDto studentDto)
	{
		StudentDto res= studentService.insertStudent(studentDto);
		return new  ResponseEntity<StudentDto>(res,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StudentDto> updateStu(@RequestBody StudentDto studentDto) 
	{
		 
		StudentDto res= studentService.editStudent(studentDto);
		return new  ResponseEntity<StudentDto>(res,HttpStatus.CREATED);
		 
	}
	
	@GetMapping("/stu/{roll}")
	public ResponseEntity<StudentDto> fetchStu(@PathVariable Integer roll) 
	{
		 
		StudentDto res= studentService.getRoll(roll);
		return new  ResponseEntity<StudentDto>(res,HttpStatus.OK);
		 
	}
	

	@DeleteMapping("/delete/{roll}")
	public ResponseEntity<ResponseMsg> DelStu(@PathVariable Integer roll) 
	{
		 
		  studentService.deleteStudent(roll);
		  return ResponseEntity.ok(new ResponseMsg("Student deleted successfully"));
	 
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<StudentDto>> allStudent() 
	{
		 
		List<StudentDto> allStu= studentService.getAllStudent();
		return new  ResponseEntity<>(allStu,HttpStatus.OK);
		 
	}

}
