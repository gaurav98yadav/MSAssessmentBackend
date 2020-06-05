package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accoflow.models.Assessment;
import com.accoflow.services.AssessmentService;

@RestController
@RequestMapping("/home")
public class AssessmentController {
  @Autowired
  private AssessmentService assessmentService;
  @PostMapping(value="/addAssessment",produces="application/json")
  public boolean addAssessment(@RequestBody Assessment assessment){
		 return assessmentService.addAssessment(assessment);
		
	}  
  @PostMapping(value="/addProject",produces="application/json")
  public boolean addProject(@RequestBody Assessment assessment){
		return assessmentService.addProject(assessment);
		
	}
  @GetMapping(value="category/{id}",produces="application/json")
  public List<Assessment> displayQuestions(@PathVariable("id") int id){
	   return assessmentService.displayAssessments(id);
  }
  @PostMapping(value="/editAssessment",produces="application/text")
  public String editAssessment(@RequestBody Assessment assessment){
		 return assessmentService.editAssessment(assessment);
	}
  @PostMapping(value="/deleteAssessment",produces="application/text")
  public String deleteAssessment(@RequestBody Assessment assessment){
		 return assessmentService.deleteAssessment(assessment);
	}
}
