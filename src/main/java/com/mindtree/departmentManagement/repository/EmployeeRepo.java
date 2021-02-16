package com.mindtree.departmentManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.departmentManagement.entity.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	

}
