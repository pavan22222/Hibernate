package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vrnda.entity.Employee;
import com.vrnda.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/home")
	public String homeHandler() {
		return "home";
	}
	
	@GetMapping("/getEmployee")
	public String getEmployee(@RequestParam Integer id,Model model) {
		try {
			Employee emp=service.retrieveEmployee(id);
			model.addAttribute("emp",emp != null ? emp:"Employee Not Found With "+id);
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("emp", "Internal Problem");
		}
		return "result";
	}
}
