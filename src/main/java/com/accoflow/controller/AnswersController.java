package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.AnswerTable;
import com.accoflow.services.AnswerService;

@RestController
@RequestMapping("/answers")
public class AnswersController {
 
	@Autowired
	AnswerService as;
	
	@GetMapping()
	public String welcome()
	{
		return "ANSWERS BABY";
	} 
	
	@GetMapping("/{question_id}")
	public List<AnswerTable> getAllQuestions(@PathVariable int question_id)
	{
		return as.getAllAnswers(question_id);
	} 
}
