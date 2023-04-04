package com.glearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.glearning.model.Employee;
import com.glearning.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.findAllEmployee();
		model.addAttribute("employees", employees);
		return "/employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("create", true);
		return "create_or_edit_employee";
	}

	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeService.findEmployeeById(id);
		model.addAttribute("employee", employee);
		model.addAttribute("create", false);
		employeeService.deleteEmployeeById(id);
		return "create_or_edit_employee";
	}

	@PostMapping("/employees")
	public String save(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
