package com.springboot.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.model.Employee;
import com.springboot.employee.service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	@ResponseBody
	public String sayHello() {
		return "Welcome User!...";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return empService.getEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees")
	public void addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable  Integer id) {
		empService.updateEmployee(id,employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public void deleteEmployee(@PathVariable  Integer id) {
		empService.deleteEmployee(id);
	}
	
	
}

