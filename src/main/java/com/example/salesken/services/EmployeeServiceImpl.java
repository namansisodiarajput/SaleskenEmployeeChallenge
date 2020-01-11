package com.example.salesken.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salesken.config.MailService;
import com.example.salesken.model.Employee;
import com.example.salesken.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MailService mailService;

	@Override
	public Employee createEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		if(employee.getEmailId().isEmpty())
			throw new Exception("email id is mandatory");
		
		if(employeeRepository.findByEmailId(employee.getEmailId()) != null)
			throw new Exception("employee already exist by this email id");
	
		Employee newEmployee = employeeRepository.save(employee);
		mailService.createMail(newEmployee.getEmailId());
		
		return newEmployee;
	}
	
	@Override
	public Employee updateEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Employee existingEmployee = employeeRepository.findByEmailId(employee.getEmailId());
		if(existingEmployee == null)
			throw new Exception("employee emailId not found");
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		
		mailService.updateMail(existingEmployee.getEmailId());
		return employeeRepository.save(existingEmployee);
	}
	
	@Override
	public Employee getEmployee(long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		mailService.getMail(existingEmployee.get().getEmailId());
		return existingEmployee.get();
	}
	
	@Override
	public boolean deleteEmployee(long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Employee> existingEmployee = employeeRepository.findById(id);

		mailService.deleteMail(existingEmployee.get().getEmailId());
		employeeRepository.deleteById(existingEmployee.get().getId());
		return true;
	}
	
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
	}

}
