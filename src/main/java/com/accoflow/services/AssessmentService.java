package com.accoflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.AssessmentDAO;
import com.accoflow.models.Assessment;

@Service
public class AssessmentService {
	@Autowired
	AssessmentDAO assessmentDAO;
	public boolean addAssessment(Assessment assessment) {
		if(!assessmentDAO.checkDuplicates(assessment))
			return false;
		if(assessment.getAssessment_type()==1)
			return assessmentDAO.quiz(assessment);
		else if(assessment.getAssessment_type()==2)
			return assessmentDAO.mcq(assessment);
		else {
			return assessmentDAO.assignment(assessment);
		}
	}
	
	public boolean addProject(Assessment assessment) {
		assessment.setFinal_marks((assessment.getBuild_marks()*0.3)+(assessment.getProcess_marks()*0.4)+(assessment.getTesting_marks()*0.3));
		return assessmentDAO.project(assessment);
	}

	public List<Assessment> displayAssessments(int id) {
		return assessmentDAO.fetchAssessments(id);
	}

	public String editAssessment(Assessment assessment) {
		if(assessment.getAssessment_type()==4)
	    	  assessment.setFinal_marks((assessment.getBuild_marks()*0.3)+(assessment.getProcess_marks()*0.4)+(assessment.getTesting_marks()*0.3));
		return assessmentDAO.editAssessment(assessment);
	}
	public String deleteAssessment(Assessment assessment) {
		return assessmentDAO.deleteAssessment(assessment);
	}

}
