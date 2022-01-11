package com.vrnda.service;

import java.util.List;

import com.vrnda.entity.Employee;

public interface EmployeeService {

	String saveEmployee(Employee emp);

	Employee retrieveEmployee(Integer id);

	List<Employee> retrieveAllEmployees();

	List<Employee> retrieveAllEmployeesByDesignations(String desg1, String desg2);

	List<Employee> retrieveAllEmployeesByDesignationsAsIterable(String desg1, String desg2);
	
	List<Object[]> retrieveMultipleSpecificCols();
	
	List<String> retrieveSpecificCol();
	
	String updateEmployeesDesignation();
	
	String insertEmployees(List<Employee> employees);
}
