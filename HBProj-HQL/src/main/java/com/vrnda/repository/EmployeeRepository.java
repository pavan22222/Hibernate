package com.vrnda.repository;

import java.util.Iterator;
import java.util.List;

import com.vrnda.entity.Employee;

 public interface EmployeeRepository {
	 Employee getEmployeeById(Integer id);
	 Integer saveEmployee(Employee emp);
	 List<Employee> retrieveAllEmployees();
	 List<Employee> retrieveAllEmployeesByDesignations(String desg1,String desg2);
	 Iterator<Employee> retrieveAllEmployeesByDesignationsAsIterable(String desg1,String desg2);
	 List<Object[]> retrieveMultipleSpecificCols();
	 List<String> retrieveSpecificCol();
	 Integer updateEmployeesDesignation();
	 Integer insertEmployees(List<Employee> employees);
}
