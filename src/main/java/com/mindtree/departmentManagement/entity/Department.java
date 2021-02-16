package com.mindtree.departmentManagement.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	
	private String departmentName;
	private short strength;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "department")
	private List<Employee> employees;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int DepartmentId, String DepartmentName, short strength, List<Employee> employees) {
		super();
		this.departmentId = DepartmentId;
		this.departmentName = DepartmentName;
		this.strength = strength;
		this.employees = employees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String DepartmentName) {
		this.departmentName = DepartmentName;
	}

	public short getStrength() {
		return strength;
	}

	public void setStrength(short strength) {
		this.strength = strength;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int DepartmentId) {
		this.departmentId = DepartmentId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
