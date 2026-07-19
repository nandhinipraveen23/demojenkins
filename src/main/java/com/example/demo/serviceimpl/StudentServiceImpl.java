package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentNotFoundException;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{
 @Autowired
	StudentRepo studentRepo;
 
	
	public Student DtotoStudent(StudentDto studentDto)
	{
		Student s = new Student();
		s.setName(studentDto.getName());
		s.setGender(studentDto.getGender());
		return s;
	}
	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		 
		Student s=DtotoStudent(studentDto);
		Student res= studentRepo.save(s);
		studentDto.setRoll(res.getRoll());
		 
		return studentDto;
	}
	
	public StudentDto  	entityToDto(Student s)
	{
		StudentDto studentDto= new StudentDto();
		studentDto.setRoll(s.getRoll());
		studentDto.setName(s.getName());
		studentDto.setGender(s.getGender());
		
		return studentDto;
		
	}

	@Override
	public List<StudentDto> getAllStudent() {
		 
		List<Student> allStu=studentRepo.findAll();
		List <StudentDto> allStuDto= new ArrayList<>();
		
		for( Student s : allStu)
		{
			StudentDto studentDto= entityToDto(s);
			allStuDto.add(studentDto);
		}
		
		return allStuDto;
	}

	@Override
	public StudentDto getRoll(Integer roll)   {
		
		
		Student s= studentRepo.findById(roll)
				.orElseThrow(()-> new StudentNotFoundException( "roll no not found"));
		
		StudentDto studentDto= entityToDto(s);
		return studentDto;
	}

	@Override
	public void deleteStudent(Integer roll)   {
		Student s= studentRepo.findById(roll)
				.orElseThrow(()-> new StudentNotFoundException( "roll no not found"));
		studentRepo.delete(s);
	}

	@Override
	public StudentDto editStudent(StudentDto studentDto) {
		 
		
		Student oldData= studentRepo.findById(studentDto.getRoll())
				.orElseThrow(()-> new StudentNotFoundException( "roll no not found"));
		
		if(studentDto.getName()!=null)
		{
			oldData.setName(studentDto.getName());
			
		}
		if(studentDto.getGender()!=null)
		{
			oldData.setGender(studentDto.getGender());
		}
		
		
		
Student res=	 studentRepo.save(oldData);

StudentDto updatedStuDto= entityToDto(res);
		return updatedStuDto;
	}

}
