package com.accoflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.TrainerDAO;
import com.accoflow.models.Trainer;

@Service
public class TrainerService {
   @Autowired
   TrainerDAO trainerDAO;
   public int addTrainer(Trainer trainer) {
	    return trainerDAO.addTrainer(trainer);   
   }
   
}
