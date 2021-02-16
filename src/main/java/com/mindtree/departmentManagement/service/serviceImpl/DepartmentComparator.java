package com.mindtree.departmentManagement.service.serviceImpl;


import java.util.Comparator;

import com.mindtree.departmentManagement.entity.Department;

public class DepartmentComparator implements Comparator<Department>{
	
	@Override
	public int compare(Department s1, Department s2) {
		int val = s1.getStrength() - s2.getStrength();
		if(val == 0)
			val = s1.getDepartmentName().compareTo(s2.getDepartmentName());
		return val;
	}


}
