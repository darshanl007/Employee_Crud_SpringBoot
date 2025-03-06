package org.bluetree.emp_crud.service;

import org.bluetree.emp_crud.dto.Employee;
import org.bluetree.emp_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public String loadEmployeeForm(Employee employee, ModelMap map) {
		map.put("employee", employee);
		return "employee-form.html";
	}

	public String addRecord(@Valid Employee employee, BindingResult result) {
		if (employeeRepository.existsByEmail(employee.getEmail())) {
			result.rejectValue("email", "error.email", "* Email Should be Unique");
		}
		if (result.hasErrors()) {
			return "employee-form.html";
		} else {
			employeeRepository.save(employee);
			return "redirect:https://www.instagram.com";
		}
	}

}
