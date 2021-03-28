package com.mindtree.departmentManagement.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	private float salary;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Department department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String name, String city, float salary, Department department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int EmployeeId) {
		this.employeeId = EmployeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", city=" + city + ", createdDate="
				+ createdDate + ", salary=" + salary + ", department=" + department + "]";
	}
}
