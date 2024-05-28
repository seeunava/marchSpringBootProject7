package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@RestController
public class MyRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	
	List<EmployeeDTO> findAllEmployees(){
		EmployeeDTO emp = new EmployeeDTO(1,"Rajiv", 1222, "rajiv@gmail.com","1234");
		EmployeeDTO emp1 = new EmployeeDTO(3,"Ramesh", 3333, "ramesh@gmail.com", "1234");
		
		
	
	List<EmployeeDTO> list = new ArrayList<>();
	list.add(emp);
	list.add(emp1);
	return list;

	
	}
	

}
