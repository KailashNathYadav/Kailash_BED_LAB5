package com.glearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.dao.EmployeeRepository;
import com.glearning.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmployeeById(long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}

}
