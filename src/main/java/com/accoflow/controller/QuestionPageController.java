package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.QuestionTable;
import com.accoflow.services.QuestionService;

@RestController
@RequestMapping("/home")
public class QuestionPageController {

	@Autowired
	QuestionService qs;
//	
//	@GetMapping()
//	public String welcome()
//	{
//		return "QUESTIONS BABY";
//	} 
	@GetMapping("/{id}")
	public List<QuestionTable >getAllQuestions(@PathVariable int id)
	{
		System.out.println("Called");
		return qs.getAllQuestions(id);
	} 
}
