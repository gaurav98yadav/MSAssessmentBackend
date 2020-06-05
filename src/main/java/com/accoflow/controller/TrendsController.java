package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.Trends;
import com.accoflow.services.TrendsService;

@RestController
@RequestMapping("/home/trends")
public class TrendsController {
  @Autowired
  private TrendsService trendsService;
  @GetMapping
  public Trends displayTrends(){
		return trendsService.displayTrends();
		
	}
}