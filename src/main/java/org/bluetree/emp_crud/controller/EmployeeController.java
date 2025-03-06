package org.bluetree.emp_crud.controller;

import org.bluetree.emp_crud.dto.Employee;
import org.bluetree.emp_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}

	@GetMapping("/add-record")
	public String loadEmployeeForm(Employee employee, ModelMap map) {
		return service.loadEmployeeForm(employee, map);
	}

	@PostMapping("/add-record")
	public String addRecord(@Valid Employee employee, BindingResult result) {
		return service.addRecord(employee, result);
	}
}
