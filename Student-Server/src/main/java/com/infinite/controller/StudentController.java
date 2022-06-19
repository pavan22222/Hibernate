package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.beans.Student;
import com.infinite.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam Integer startIndex,@RequestParam Integer lastIndex){
		return new ResponseEntity<List<Student>>(service.getAllStudents(startIndex,lastIndex), HttpStatus.ACCEPTED);
	}
	
}
