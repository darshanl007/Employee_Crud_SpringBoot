package org.bluetree.emp_crud.service;

import java.util.List;
import java.util.Random;

import org.bluetree.emp_crud.dto.Employee;
import org.bluetree.emp_crud.helper.EmailSender;
import org.bluetree.emp_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmailSender emailSender;

	public String loadEmployeeForm(Employee employee, ModelMap map) {
		map.put("employee", employee);
		return "employee-form.html";
	}

	public String addRecord(@Valid Employee employee, BindingResult result, HttpSession session) {
		if (employeeRepository.existsByEmail(employee.getEmail())) {
			result.rejectValue("email", "error.email", "* Email Should be Unique");
		}
		if (result.hasErrors()) {
			return "employee-form.html";
		} else {
			int otp = new Random().nextInt(1000, 10000);
			employee.setOtp(otp);
			employeeRepository.save(employee);
			emailSender.send(employee);
			System.err.println(employee.getOtp());
			session.setAttribute("success", "OTP Sent Successfully");
			session.setAttribute("id", employee.getId());
			return "employee-otp.html";
		}
	}

	public String verifyOtp(int id, int otp, HttpSession session) {
		Employee employee = employeeRepository.findById(id).orElseThrow();
		if (employee.getOtp() == otp) {
			employee.setVerfied(true);
			employeeRepository.save(employee);
			session.setAttribute("success", "Employee Email Verified and Record Added To Database Successfully");
			return "home.html";
		} else {
			session.setAttribute("failure", "OTP Missmatch");
			session.setAttribute("id", employee.getId());
			return "redirect:/otp/" + employee.getId();
		}
	}

	public String resendOtp(int id, HttpSession session) {
		Employee employee = employeeRepository.findById(id).orElseThrow();
		employee.setOtp(new Random().nextInt(1000, 10000));
		employee.setVerfied(false);
		employeeRepository.save(employee);
		System.err.println(employee.getOtp());
		emailSender.send(employee);
		session.setAttribute("success", "OTP Resent Successfully");
		return "redirect:/otp/" + employee.getId();
	}

	public String fetchRecords(HttpSession session, ModelMap map) {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			session.setAttribute("failure", "No Employee Record Found");
			return "employee-records.html";
		} else {
			session.setAttribute("success", "Employee Records");
			map.put("employees", employees);
			return "employee-records.html";
		}
	}

	public String deleteRecord(@RequestParam int id, ModelMap map, HttpSession session) {
		employeeRepository.deleteById(id);
		session.setAttribute("success", "Employee Record Deleted Successfully");
		return "home.html";
	}

	public String editRecord(int id, ModelMap map) {
		Employee employee = employeeRepository.findById(id).orElseThrow();
		map.put("employee", employee);
		map.put("edit", "edit");
		return "employee-edit-record.html";
	}

	public String updateRecord(Employee employee, ModelMap map, HttpSession session) {
		employeeRepository.save(employee);
		session.setAttribute("success", "Employee Record Updated Successfully");
		return "home.html";
	}

}
