package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.Employee;
import com.accoflow.models.QuestionTable;
import com.accoflow.services.EmployeeService;
import com.accoflow.services.QuestionService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	EmployeeService empService;
	
//	@Autowired
//	QuestionService qs;

	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return empService.getAlLEmployees();
	}
	@GetMapping(path = "/get")
	public String getResponse() {
		return "Hello World";
	}
//	
//	@GetMapping("/getQuestions/{id}")
//	public List<QuestionTable >getAllQuestions(@PathVariable int id)
//	{
//		return qs.getAllQuestions(id);
//	} 
	
	

}
