package com.mindtree.departmentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.departmentManagement.dto.DepartmentDto;
import com.mindtree.departmentManagement.entity.Department;
import com.mindtree.departmentManagement.exception.DepartmentServiceException;
import com.mindtree.departmentManagement.exception.InvalidDepartmentException;


@Service
public interface DepartmentService{
	
	public List<DepartmentDto> getAllDetails() throws DepartmentServiceException;
	
	public DepartmentDto getDepartmentById(int id) throws  DepartmentServiceException;
	
	public DepartmentDto addDepartment(DepartmentDto s) throws DepartmentServiceException;
}

