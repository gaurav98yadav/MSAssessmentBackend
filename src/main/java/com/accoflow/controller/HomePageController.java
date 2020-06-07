package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.dto.Scorecard;
import com.accoflow.models.Grad;
import com.accoflow.services.HomeService;

@RestController
@RequestMapping("/home")
public class HomePageController {
  @Autowired
  private HomeService homeService;
  @GetMapping
  public List<Grad> displayGrads(){
		return homeService.displayGrads();
		
	}
  @GetMapping("/profile/{id}")
  public Scorecard profile(@PathVariable("id") int id){
		return homeService.profile(id);
		
	}
}
