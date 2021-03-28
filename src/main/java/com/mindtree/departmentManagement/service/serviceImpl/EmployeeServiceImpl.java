package com.mindtree.departmentManagement.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.departmentManagement.dto.EmployeeDto;
import com.mindtree.departmentManagement.entity.Department;
import com.mindtree.departmentManagement.entity.Employee;
import com.mindtree.departmentManagement.exception.DepartmentServiceException;
import com.mindtree.departmentManagement.exception.EmployeeServiceException;
import com.mindtree.departmentManagement.exception.InvalidDepartmentException;
import com.mindtree.departmentManagement.exception.InvalidEmployeeException;
import com.mindtree.departmentManagement.repository.DepartmentRepo;
import com.mindtree.departmentManagement.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	private static ModelMapper mapper = new ModelMapper();

	public EmployeeDto entityToDto(Employee e) {
		ModelMapper mapper = new ModelMapper();
		EmployeeDto map = mapper.map(e, EmployeeDto.class);
		return map;
	}

	public Employee dtoToEntity(EmployeeDto edto) {
		Employee emp = new Employee();
		ModelMapper mapper = new ModelMapper();
		Employee map = mapper.map(edto, Employee.class);
		return map;
	}

	public List<Employee> dtoToEntity(List<EmployeeDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<EmployeeDto> entityToDto(List<Employee> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	List<Employee> EmployeeList = new ArrayList<>();

	public List<EmployeeDto> getAllEmployees() throws EmployeeServiceException {

		List<Employee> li;
		try {
			li = new ArrayList<>();
			employeeRepo.findAll().forEach(li::add);
		} catch (RuntimeException e) {
			throw new EmployeeServiceException("cant get all details",e);
		}
		return entityToDto(li);
	}

	public EmployeeDto getEmployeeById(int id) throws EmployeeServiceException {

		Employee result = null;

		try {
			result = employeeRepo.findById(id)
					.orElseThrow(() -> new InvalidEmployeeException("Employee ID not found"));
		} catch (InvalidEmployeeException e) {
			throw new EmployeeServiceException("Cant get employee",e);
		}
		return entityToDto(result);
	}

	public EmployeeDto addEmployeeById(Employee s, int id) throws EmployeeServiceException {
		Employee pass;
		try {
			Department per = departmentRepo.findById(id)
					.orElseThrow(() -> new InvalidDepartmentException("Department with id:" + id + " not found"));
			pass = null;

			List<Employee> li = new ArrayList<>();
			pass = employeeRepo.save(s);
			per.setEmployees(li);
			pass.setDepartment(per);
			per = departmentRepo.save(per);

		} catch (InvalidDepartmentException e) {
			throw new EmployeeServiceException("Cant add data to Database",e);
		}
		System.out.println("Added Details");
		return entityToDto(pass);
	}
}
