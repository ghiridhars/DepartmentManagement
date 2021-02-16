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
		EmployeeDto map= mapper.map(e,EmployeeDto.class);
		return map;
	}
	
	public Employee dtoToEntity(EmployeeDto edto) {
		Employee emp = new Employee();
		ModelMapper mapper = new ModelMapper();
		Employee map= mapper.map(edto,Employee.class);		
		return map;
	}
	
	public List<Employee> dtoToEntity(List<EmployeeDto> dto)
	{
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<EmployeeDto> entityToDto(List<Employee> emp)
	{
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	

	List<Employee> EmployeeList = new ArrayList<>();

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> li= new ArrayList<>();
		employeeRepo.findAll().forEach(li::add);
		return entityToDto(li);
	}
	
	public EmployeeDto getEmployeeById(int id) throws InvalidEmployeeException {
		Employee result = employeeRepo.findById(id).orElse(null);
//		Department c = DepartmentRepo.findById(result.getEmployeeId()).orElse(null);
		if(result == null)
			throw new InvalidEmployeeException("Passport ID not found");
		else
			return entityToDto(result);
	}
	
	public EmployeeDto addEmployeeById(Employee s,int id) throws InvalidEmployeeException{
		Department per= departmentRepo.findById(id).orElse(null);
		Employee pass= null;
		if(per== null) {
			System.out.println("NULL");
			throw new InvalidEmployeeException("Department with id:"+id+"not found");
		}
		else {
			List<Employee> li = new ArrayList<>();
			pass = employeeRepo.save(s);
			per.setEmployees(li);
			pass.setDepartment(per);
			per = departmentRepo.save(per);
		}
		System.out.println("Added Details");
		return entityToDto(pass);
	}
}
