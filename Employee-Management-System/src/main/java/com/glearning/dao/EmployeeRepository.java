package com.glearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
