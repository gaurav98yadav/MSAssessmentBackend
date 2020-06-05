package com.accoflow.models;

public class Assessment {
	
	private int assessment_id;
	private int assessment_type;
	private int grad_id;
	private int trainer_id;
	public Assessment(int assessment_id, int assessment_type, int grad_id, int trainer_id, String trainer_feedback,
			String course, String test_name, double final_marks, int build_marks, int testing_marks, int process_marks,
			String grad_name) {
		super();
		this.assessment_id = assessment_id;
		this.assessment_type = assessment_type;
		this.grad_id = grad_id;
		this.trainer_id = trainer_id;
		this.trainer_feedback = trainer_feedback;
		this.course = course;
		this.test_name = test_name;
		this.final_marks = final_marks;
		this.build_marks = build_marks;
		this.testing_marks = testing_marks;
		this.process_marks = process_marks;
		this.grad_name = grad_name;
	}
	public Assessment() {
		
	}
	private String trainer_feedback;
	private String course;
	private String test_name;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	private double final_marks;
	private int build_marks;
	private int testing_marks;
	private int process_marks;
	private String grad_name;
	public String getGrad_name() {
		return grad_name;
	}
	public void setGrad_name(String grad_name) {
		this.grad_name = grad_name;
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
	public int getAssessment_id() {
		return assessment_id;
	}
	public void setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
	}
	public int getAssessment_type() {
		return assessment_type;
	}
	public void setAssessment_type(int assessment_type) {
		this.assessment_type = assessment_type;
	}
	public int getGrad_id() {
		return grad_id;
	}
	public void setGrad_id(int grad_id) {
		this.grad_id = grad_id;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public String getTrainer_feedback() {
		return trainer_feedback;
	}
	public void setTrainer_feedback(String trainer_feedback) {
		this.trainer_feedback = trainer_feedback;
	}
	public double getFinal_marks() {
		return final_marks;
	}
	public void setFinal_marks(double d) {
		this.final_marks = d;
	}

}
