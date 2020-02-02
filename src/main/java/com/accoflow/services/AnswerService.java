package com.accoflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.AnswerDAO;
import com.accoflow.models.AnswerTable;

@Service
public class AnswerService {
	
	@Autowired
	AnswerDAO dao;
	
	public List<AnswerTable> getAllAnswers(int q_id){
		return dao.getAllAnswers(q_id);
	}
}
