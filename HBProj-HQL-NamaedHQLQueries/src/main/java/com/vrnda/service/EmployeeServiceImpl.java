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
	public Employee retrieveEmployee(Integer id) {
		return repository.getEmployeeById(id);
	}


	@Override
	public List<Employee> retrieveAllEmployees() {
		List<Employee> list=repository.retrieveAllEmployees();
		return list;
	}


	@Override
	public String saveEmployee(Employee emp) {
		return "Employee Created With "+repository.saveEmployee(emp); 
	}


	@Override
	public List<Employee> retrieveAllEmployeesByDesignations(String desg1, String desg2) {
		return repository.retrieveAllEmployeesByDesignations(desg1, desg2);
	}


	@Override
	public List<Employee> retrieveAllEmployeesByDesignationsAsIterable(String desg1, String desg2) {	
		Iterator<Employee> iterator=repository.retrieveAllEmployeesByDesignationsAsIterable(desg1, desg2);
		List<Employee> list=new ArrayList<Employee>();
		if(iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}


	@Override
	public List<Object[]> retrieveMultipleSpecificCols() {
		return repository.retrieveMultipleSpecificCols();
	}


	@Override
	public List<String> retrieveSpecificCol() {
		return repository.retrieveSpecificCol();
	}


	@Override
	public String updateEmployeesDesignation() {
		return repository.updateEmployeesDesignation() +" Records are Updated";
	}


	@Override
	public String insertEmployees(List<Employee> employees) {
		return repository.insertEmployees(employees) +" Records are Updated";
	}

}
