package com.mindtree.departmentManagement.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DepartmentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
		
	private String departmentName;
	private short strength;


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
}
