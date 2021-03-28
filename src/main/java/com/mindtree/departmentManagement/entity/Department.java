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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
	private List<Employee> employees;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentId, Date createdDate, String departmentName, short strength,
			List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.createdDate = createdDate;
		this.departmentName = departmentName;
		this.strength = strength;
		this.employees = employees;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", createdDate=" + createdDate + ", departmentName="
				+ departmentName + ", strength=" + strength + ", employees=" + employees + "]";
	}

}
