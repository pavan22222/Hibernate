package com.vrnda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrnda.entity.Employee;
import com.vrnda.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee retrieveEmployee(Integer id) {
		return repository.getEmployeeById(id);
	}

}
