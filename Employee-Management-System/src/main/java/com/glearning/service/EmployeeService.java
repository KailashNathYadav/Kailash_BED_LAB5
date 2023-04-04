package com.glearning.service;

import java.util.List;

import com.glearning.model.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee findEmployeeById(long id);

	void deleteEmployeeById(long id);
}
