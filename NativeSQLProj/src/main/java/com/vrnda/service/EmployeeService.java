package com.vrnda.service;

import java.util.List;

import com.vrnda.entity.Employee;

public interface EmployeeService {

	 List<Object[]> retrieveAllEmployeesWithoutMapping();
	 List<Employee> retrieveAllEmployeesWithMapping();
	 String updateEmployeeSalary(Integer id,Float salary);
	 String insertEmployee(Employee emp);
	 String deleteEmployee(Long id);
	 Integer checkCredentials(String username,String password);
}
