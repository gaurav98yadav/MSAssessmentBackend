package com.accoflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.QuestionDAO;
import com.accoflow.models.QuestionTable;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO dao;
	
	public List<QuestionTable> getAllQuestions(int id){
		return dao.getAllQuestions( id);
	}

}
