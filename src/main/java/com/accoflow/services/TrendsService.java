package com.accoflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.TrendsDAO;
import com.accoflow.models.Trends;

@Service
public class TrendsService {
   @Autowired
   TrendsDAO trendsDAO;
   public Trends displayTrends() {
	    return trendsDAO.displayTrends();

   }
   
}