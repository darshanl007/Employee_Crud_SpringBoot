package org.bluetree.emp_crud.controller;

import org.bluetree.emp_crud.dto.Employee;
import org.bluetree.emp_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
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
	public String addRecord(@Valid Employee employee, BindingResult result, HttpSession session) {
		return service.addRecord(employee, result, session);
	}

	@GetMapping("/otp/{id}")
	public String loadOtp(@PathVariable int id, ModelMap map) {
		map.put("id", id);
		return "employee-otp.html";
	}

	@PostMapping("/otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, HttpSession session) {
		return service.verifyOtp(id, otp, session);
	}

	@GetMapping("/resend-otp/{id}")
	public String resendOtp(@PathVariable int id, HttpSession session) {
		return service.resendOtp(id, session);
	}

	@GetMapping("/employee-records")
	public String fetchRecords(HttpSession session, ModelMap map) {
		return service.fetchRecords(session, map);
	}

	@GetMapping("/delete-record")
	public String deleteRecord(@RequestParam int id, ModelMap map, HttpSession session) {
		return service.deleteRecord(id, map, session);
	}

	@GetMapping("/edit-record")
	public String editRecord(@RequestParam int id, ModelMap map) {
		return service.editRecord(id, map);
	}

	@PostMapping("/update-record")
	public String updateRecord(Employee employee, ModelMap map, HttpSession session) {
		return service.updateRecord(employee, map, session);
	}

}
