package com.accoflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.HomeDAO;
import com.accoflow.dto.Scorecard;
import com.accoflow.models.Grad;

@Service
public class HomeService {
   @Autowired
   HomeDAO homeDAO;
   public List<Grad> displayGrads() {
	    List<Grad>grads = homeDAO.displayGrads();
	    for (Grad grad :grads)
	    {
	    	grad.setTotal_marks((grad.getQuiz_marks()*0.2)+(grad.getProject_marks()*0.5)+(grad.getAssignment_marks()*0.2)+(grad.getMcq_marks()*0.1));
	    }
	    return grads;
   }
public Scorecard profile(int id) {
	
	Scorecard sc = homeDAO.profile(id);
	return sc;
}
}