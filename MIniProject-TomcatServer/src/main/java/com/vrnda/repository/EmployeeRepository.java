package com.vrnda.repository;

import com.vrnda.entity.Employee;

public interface EmployeeRepository {
	public Employee getEmployeeById(Integer id);
}
