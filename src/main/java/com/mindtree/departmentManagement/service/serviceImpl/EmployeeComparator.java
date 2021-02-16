package com.mindtree.departmentManagement.service.serviceImpl;

import java.util.Comparator;

import com.mindtree.departmentManagement.entity.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee s1, Employee s2) {
		int val = (int)(s1.getSalary()- s2.getSalary());
		if (val == 0)
			val = s2.getName().compareTo(s1.getName());
		return val;
	}
}