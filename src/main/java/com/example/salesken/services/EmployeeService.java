package com.example.salesken.services;

import java.util.List;

import com.example.salesken.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee) throws Exception;
	Employee updateEmployee(Employee employee) throws Exception;
	Employee getEmployee(long id) throws Exception;
	boolean deleteEmployee(long id) throws Exception;
	List<Employee> getAllEmployee();

}
