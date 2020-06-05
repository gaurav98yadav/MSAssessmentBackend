package com.accoflow.models;

public class Project {
	
	private int assessment_id;
	private int build_marks;
	private int testing_marks;
	private int process_marks;
	public int getAssessment_id() {
		return assessment_id;
	}
	public void setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
	}
	public int getBuild_marks() {
		return build_marks;
	}
	public void setBuild_marks(int build_marks) {
		this.build_marks = build_marks;
	}
	public int getTesting_marks() {
		return testing_marks;
	}
	public void setTesting_marks(int testing_marks) {
		this.testing_marks = testing_marks;
	}
	public int getProcess_marks() {
		return process_marks;
	}
	public void setProcess_marks(int process_marks) {
		this.process_marks = process_marks;
	}

}
