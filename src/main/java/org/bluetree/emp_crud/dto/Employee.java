package org.bluetree.emp_crud.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 5, max = 30, message = "* Enter Between 5~30 Charecters")
	private String name;
	@Email(message = "* Enter Proper Email")
	@NotEmpty(message = "* It is Required Field")
	private String email;
	@NotNull(message = "* Date of Birth is Required")
	@Past(message = "* DOB must be in the past")
	private LocalDate dob;
	@Min(value = 10000, message = "* Minimum salary should be 10,000")
	@Max(value = 500000, message = "* Maximum salary allowed is 500,000")
	private double salary;
	@NotNull(message = "* Status is Required")
	private boolean status;
}
