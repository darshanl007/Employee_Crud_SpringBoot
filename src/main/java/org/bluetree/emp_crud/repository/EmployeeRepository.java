package org.bluetree.emp_crud.repository;

import org.bluetree.emp_crud.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsByEmail(String email);

}
