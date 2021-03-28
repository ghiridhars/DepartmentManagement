package com.mindtree.departmentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.departmentManagement.dto.EmployeeDto;
import com.mindtree.departmentManagement.entity.Employee;
import com.mindtree.departmentManagement.exception.DepartmentManageException;
import com.mindtree.departmentManagement.exception.DepartmentServiceException;
import com.mindtree.departmentManagement.exception.EmployeeServiceException;
import com.mindtree.departmentManagement.exception.InvalidEmployeeException;
import com.mindtree.departmentManagement.service.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	@RequestMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees()throws DepartmentManageException {
		
		try {
			System.out.println("Getting all students");
			return new ResponseEntity(empService.getAllEmployees(),HttpStatus.ACCEPTED);
		} catch (EmployeeServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Cant get employees",e);
		}
	}

	@RequestMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) throws DepartmentManageException{
		EmployeeDto per=null;
		System.out.println("Getting Employee by id");
		try {
			per = empService.getEmployeeById(id);
			return new ResponseEntity(per,HttpStatus.ACCEPTED);
		} catch (EmployeeServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Cant get employees",e);
		}
	}
	
	@PostMapping("/addEmployee/{id}")
	public EmployeeDto addEmployee(@RequestBody Employee s,@PathVariable int id) throws DepartmentManageException{
		EmployeeDto stu = null;
		try {
			stu = empService.addEmployeeById(s,id);
		} catch (EmployeeServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Cant get employees",e);
		}
		return stu;
	}

}
