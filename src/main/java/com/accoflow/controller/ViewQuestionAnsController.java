package com.accoflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.QuestionAnswer;
import com.accoflow.services.QAService;

@RestController
@RequestMapping("/questions")
public class ViewQuestionAnsController {
	
	@Autowired
	QAService qaService;

	@GetMapping("/{id}")
	public QuestionAnswer getAnswers(@PathVariable int id)
	{
		return qaService.getAnswers(id);
	}

	
	

}
