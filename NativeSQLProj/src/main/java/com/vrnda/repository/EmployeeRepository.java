package com.vrnda.repository;

import java.util.List;

import com.vrnda.entity.Employee;

 public interface EmployeeRepository {
	 List<Object[]> retrieveAllEmployeesWithoutMapping();
	 List<Employee> retrieveAllEmployeesWithMapping();
	 Integer updateEmployeeSalary(Integer id,Float salary);
	 Integer insertEmployee(Employee emp);
	 Integer deleteEmployee(Long id);
	 Integer checkCredentials(String username,String password);
	
}
