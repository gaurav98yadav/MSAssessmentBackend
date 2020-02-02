package com.accoflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.QADAO;
import com.accoflow.models.QuestionAnswer;

@Service
public class QAService {
	
	@Autowired
	QADAO dao;
	
	public QuestionAnswer getAnswers(int id){
		return dao.getAnswers(id);
	}

}
