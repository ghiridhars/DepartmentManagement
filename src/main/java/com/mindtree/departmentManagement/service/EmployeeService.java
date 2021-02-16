package com.mindtree.departmentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.departmentManagement.entity.Employee;


@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeByName(int id);
	
	public Employee addEmployee(Employee s);
}
