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

import com.mindtree.departmentManagement.entity.Employee;
import com.mindtree.departmentManagement.exception.DepartmentManageException;
import com.mindtree.departmentManagement.exception.InvalidEmployeeException;
import com.mindtree.departmentManagement.service.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		System.out.println("Getting all students");
		return empService.getAllEmployees();
	}

	@RequestMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) throws InvalidEmployeeException{
		Employee per=null;
		System.out.println("Getting Employee by id");
		try {
			per = empService.getEmployeeById(id);
			return new ResponseEntity(per,HttpStatus.ACCEPTED);
		} catch (InvalidEmployeeException e) {
			e.printStackTrace();
			throw new InvalidEmployeeException("Employee not found");
//			return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addEmployee/{id}")
	public Employee addEmployee(@RequestBody Employee s,@PathVariable int id){
		Employee stu = null;
		try {
			stu = empService.addEmployeeById(s,id);
		} catch (DepartmentManageException e) {
			e.printStackTrace();
		}
		return stu;
	}

}
