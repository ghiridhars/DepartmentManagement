package com.mindtree.departmentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.departmentManagement.entity.Department;
import com.mindtree.departmentManagement.entity.Employee;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	

}
