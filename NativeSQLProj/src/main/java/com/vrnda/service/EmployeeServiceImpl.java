package com.vrnda.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.vrnda.entity.Employee;
import com.vrnda.repository.EmployeeRepository;


public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository repository;
	
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Object[]> retrieveAllEmployeesWithoutMapping() {
		return repository.retrieveAllEmployeesWithoutMapping();
	}

	@Override
	public List<Employee> retrieveAllEmployeesWithMapping() {
		return repository.retrieveAllEmployeesWithMapping();
	}

	@Override
	public String updateEmployeeSalary(Integer id, Float salary) {
		return repository.updateEmployeeSalary(id, salary)+" Records are Updated";
	}

	@Override
	public String insertEmployee(Employee emp) {
		return repository.insertEmployee(emp)+" Records are Inserted";
	}

	@Override
	public String deleteEmployee(Long id) {
		return repository.deleteEmployee(id)+" Records are Deleted";
	}

	@Override
	public Integer checkCredentials(String username, String password) {
		return repository.checkCredentials(username, password);
	}


	

}
