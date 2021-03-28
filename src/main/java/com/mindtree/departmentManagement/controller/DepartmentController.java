package com.mindtree.departmentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.departmentManagement.dto.DepartmentDto;
import com.mindtree.departmentManagement.entity.Department;
import com.mindtree.departmentManagement.entity.Employee;
import com.mindtree.departmentManagement.exception.DepartmentManageException;
import com.mindtree.departmentManagement.exception.DepartmentServiceException;
import com.mindtree.departmentManagement.exception.InvalidDepartmentException;
import com.mindtree.departmentManagement.service.serviceImpl.DepartmentServiceImpl;

@RestController
@RequestMapping("/Department")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl deptService;
	
	@RequestMapping("/getAllDetails")
	public List<DepartmentDto> getAllDetails() throws DepartmentManageException {
		System.out.println("Getting all Department details");
		try {
			return deptService.getAllDetails();
		} catch (DepartmentServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Department not found",e);
		}
	}
	
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<?> getDepartmentDetails(@PathVariable int id) throws DepartmentManageException {
		DepartmentDto pass=null;
		System.out.println("Getting Department by id");
		try {
			pass = deptService.getDepartmentById(id);
			return new ResponseEntity( pass,HttpStatus.ACCEPTED);
		} catch (DepartmentServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Department not found",e);
		}
	}

	@GetMapping("/getEmployeesByDepartment/{id}")
	public ResponseEntity<?> getEmployeeDetailsById(@PathVariable int id) throws DepartmentManageException {
		List<Employee> li=null;
		System.out.println("Getting Employee details by id");
		try {
			li = deptService.getEmployeesById(id);
			return new ResponseEntity(li,HttpStatus.ACCEPTED);
		} catch (DepartmentServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Department not found",e);
		}
	}

	@PostMapping("/addDetails")
	public DepartmentDto addDetails(@RequestBody DepartmentDto s) throws DepartmentManageException {
		DepartmentDto pass=null;
		try {
			pass= deptService.addDepartment(s);
		} catch (DepartmentServiceException e) {
			e.printStackTrace();
			throw new DepartmentManageException("Department not found",e);
		}
		return pass;
	}

}
