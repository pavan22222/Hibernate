package com.vrnda.test;

import com.vrnda.entity.Employee;
import com.vrnda.repository.EmployeeRepositoryImpl;
import com.vrnda.service.EmployeeService;
import com.vrnda.service.EmployeeServiceImpl;

public class NativeSQLTest {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl(new EmployeeRepositoryImpl());

		System.out.println("................................................");
		System.out.println(service.retrieveAllEmployeesWithoutMapping());

		System.out.println("................................................");
		System.out.println(service.retrieveAllEmployeesWithMapping());

		System.out.println("................................................");
		System.out.println(service.updateEmployeeSalary(35, 62000.0f));
		
		//System.out.println("................................................");
		//System.out.println(service.insertEmployee(new Employee(null, "Mahesh", "Developer", 24, null, 26000.0f, null, null, null)));
		
		System.out.println("................................................");
		System.out.println(service.deleteEmployee(47l));
		
		System.out.println("................................................");
		System.out.println(service.checkCredentials("Pavan", "Pavan"));
	
	}
}
