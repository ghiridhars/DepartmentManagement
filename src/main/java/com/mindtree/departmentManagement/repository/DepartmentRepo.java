package com.mindtree.departmentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.departmentManagement.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
