package org.bluetree.emp_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}
}
