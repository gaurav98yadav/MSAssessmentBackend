package com.accoflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.Trainer;
import com.accoflow.services.TrainerService;

@RestController
@RequestMapping("/home")
public class LoginController {
  @Autowired
  private TrainerService trainerService;
  @PostMapping(value="/addTrainer",produces="application/json")
  public int addEmployee(@RequestBody Trainer trainer){
	return trainerService.addTrainer(trainer); 	
  }
}
