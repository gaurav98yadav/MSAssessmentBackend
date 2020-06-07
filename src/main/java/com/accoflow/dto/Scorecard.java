package com.accoflow.dto;

import java.util.List;

import com.accoflow.models.Assessment;
import com.accoflow.models.Grad;

public class Scorecard {
	
	private Grad grad;
	private List<Assessment> assessments;
	double locationpercentile;
	public double getLocationpercentile() {
		return locationpercentile;
	}
	public void setLocationpercentile(double d) {
		this.locationpercentile = d;
	}
	public Grad getGrad() {
		return grad;
	}
	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	public List<Assessment> getAssessments() {
		return assessments;
	}
	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}
}