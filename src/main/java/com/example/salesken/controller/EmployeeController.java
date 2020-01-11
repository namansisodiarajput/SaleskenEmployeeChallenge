package com.example.salesken.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.salesken.model.Employee;
import com.example.salesken.services.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "create employee and email id is unique")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Employee createEmployee(@RequestBody Employee employee) throws Exception {
		return employeeService.createEmployee(employee);
	}
	
	@ApiOperation(value = "update employee")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
		return employeeService.updateEmployee(employee);
	}
	
	@ApiOperation(value = "get employee by id")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public Employee getEmployee(@PathVariable(value = "id") long id) throws Exception {
    	return employeeService.getEmployee(id);
    }
	
	@ApiOperation(value = "delete employee by id")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteEmployee(@PathVariable(value = "id") long id) throws Exception {
    	return employeeService.deleteEmployee(id);
    }
	   
	@ApiOperation(value = "get all employee")
    @RequestMapping(value = "/get-list", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> getList() throws Exception {
    	return employeeService.getAllEmployee();
    }

}
