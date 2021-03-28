package com.mindtree.departmentManagement.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.departmentManagement.dto.DepartmentDto;
import com.mindtree.departmentManagement.dto.EmployeeDto;
import com.mindtree.departmentManagement.entity.Department;
import com.mindtree.departmentManagement.entity.Employee;
import com.mindtree.departmentManagement.exception.DepartmentServiceException;
import com.mindtree.departmentManagement.exception.InvalidDepartmentException;
import com.mindtree.departmentManagement.exception.InvalidEmployeeException;
import com.mindtree.departmentManagement.repository.DepartmentRepo;
import com.mindtree.departmentManagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	private static ModelMapper mapper = new ModelMapper();

	public DepartmentDto entityToDto(Department e) {
		ModelMapper mapper = new ModelMapper();
		DepartmentDto map = mapper.map(e, DepartmentDto.class);
		return map;
	}

	public Department dtoToEntity(DepartmentDto edto) {
		Department emp = new Department();
		ModelMapper mapper = new ModelMapper();
		Department map = mapper.map(edto, Department.class);
		return map;
	}

	public List<Department> dtoToEntity(List<DepartmentDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<DepartmentDto> entityToDto(List<Department> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public List<DepartmentDto> getAllDetails() throws DepartmentServiceException {
		List<Department> li = new ArrayList<>();
		try {
			departmentRepo.findAll().forEach(li::add);
			li.stream().findFirst().orElseThrow(() -> new InvalidDepartmentException("Empty result set"));
			li.sort(new DepartmentComparator());
			return entityToDto(li);
		} catch (RuntimeException e) {
			throw new DepartmentServiceException("Service layer Exception when getting all details",e);
		}
	}

	public DepartmentDto getDepartmentById(int id) throws DepartmentServiceException {
		Department result = null;
		try {
			result = departmentRepo.findById(id)
					.orElseThrow(() -> new InvalidDepartmentException("Department ID not found"));
		} catch (InvalidDepartmentException e) {
			throw new DepartmentServiceException("Service layer Exception when getting department details",e);
		}
		return entityToDto(result);
	}

	public DepartmentDto addDepartment(DepartmentDto s) throws DepartmentServiceException {
		System.out.println("Added");
		try {
			Department de = dtoToEntity(s);
			departmentRepo.save(de);
		} catch (RuntimeException e) {
			throw new DepartmentServiceException("Service layer Exception when adding department",e);
		}
		return s;
	}

	public List<Employee> getEmployeesById(int id) throws DepartmentServiceException {
		Department result = null;

		List<Employee> li;
		try {
			result = departmentRepo.findById(id)
					.orElseThrow(() -> new InvalidDepartmentException("Department ID not found"));
			li = result.getEmployees();
			li.sort(new EmployeeComparator());
		} catch (InvalidDepartmentException e) {
			throw new DepartmentServiceException("Service layer Exception when fetching employees of a department",e);
		}
		return li;
	}

}
