package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.beans.Student;
import com.infinite.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<Student> getAllStudents(Integer startIndex,Integer lastIndex){
		return repository.getAllStudents(startIndex,lastIndex);
	}
}
