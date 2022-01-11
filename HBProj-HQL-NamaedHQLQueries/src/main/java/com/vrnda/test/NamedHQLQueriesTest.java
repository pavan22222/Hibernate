package com.vrnda.test;

import java.util.List;

import com.vrnda.entity.Employee;
import com.vrnda.repository.EmployeeRepositoryImpl;
import com.vrnda.service.EmployeeService;
import com.vrnda.service.EmployeeServiceImpl;

public class NamedHQLQueriesTest {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
		//		System.out.println(service.retrieveAllEmployees());
		//		System.out.println("................................................");
		/*
		 * 
		 * Employee emp=new Employee(); emp.setAge(24);emp.setName("Srikanth");
		 * emp.setDesignation("Developer"); emp.setSalary(26000.0f);
		 * emp.setDoj(LocalDateTime.of(2020, 12, 07,9,30));
		 * System.out.println(service.saveEmployee(emp));
		 * 
		 */
		//		System.out.println("................................................");
		//		List<Employee> list=service.retrieveAllEmployeesByDesignations("Developer", "Developer");
		//		list.forEach(obj->{
		//			System.out.println(obj.getClass().getName());
		//		});
		//		System.out.println("................................................");
		//		List<Employee> list=service.retrieveAllEmployeesByDesignationsAsIterable("Developer", null);
		//		list.forEach(obj->{
		//			System.out.println(obj.getClass().getName());
		//			System.out.println(obj.getVersion());
		//			System.out.println(obj.getName());
		//		});

		//		System.out.println("................................................");
		//		List<Object[]> list=service.retrieveMultipleSpecificCols();
		//		list.forEach(obj->{
		//			for(Object object:obj) {
		//				System.out.println(object);
		//			}
		//		});

		/*
		 * System.out.println("................................................");
		 * List<String> list=service.retrieveSpecificCol(); list.forEach(obj->{
		 * System.out.println(obj); });
		 */
		//		System.out.println("................................................");
		//		System.out.println(service.retrieveEmployee(35));

				System.out.println("................................................");
				System.out.println(service.updateEmployeesDesignation());

		/*
		 * System.out.println("................................................");
		 * System.out.println(service.insertEmployees(null));
		 */
	}
}
