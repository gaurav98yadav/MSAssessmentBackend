package com.accoflow.models;

public class Grad {
	
	private int grad_id;
	private String grad_name;
	private String grad_location;
	private int grad_year;
	private String grad_college;
	private int quiz_marks;
	private int mcq_marks;
	private int project_marks;
	private int assignment_marks;
	private double total_marks;
	public int getGrad_id() {
		return grad_id;
	}
	public void setGrad_id(int grad_id) {
		this.grad_id = grad_id;
	}
	public String getGrad_name() {
		return grad_name;
	}
	public void setGrad_name(String grad_name) {
		this.grad_name = grad_name;
	}
	public String getGrad_location() {
		return grad_location;
	}
	public void setGrad_location(String grad_location) {
		this.grad_location = grad_location;
	}
	public int getGrad_year() {
		return grad_year;
	}
	public void setGrad_year(int grad_year) {
		this.grad_year = grad_year;
	}
	public String getGrad_college() {
		return grad_college;
	}
	public void setGrad_college(String grad_college) {
		this.grad_college = grad_college;
	}
	public int getQuiz_marks() {
		return quiz_marks;
	}
	public void setQuiz_marks(int quiz_marks) {
		this.quiz_marks = quiz_marks;
	}
	public int getMcq_marks() {
		return mcq_marks;
	}
	public void setMcq_marks(int mcq_marks) {
		this.mcq_marks = mcq_marks;
	}
	public int getProject_marks() {
		return project_marks;
	}
	public void setProject_marks(int project_marks) {
		this.project_marks = project_marks;
	}
	public int getAssignment_marks() {
		return assignment_marks;
	}
	public void setAssignment_marks(int assignment_marks) {
		this.assignment_marks = assignment_marks;
	}
	public double getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(double d) {
		this.total_marks = d;
	}

}
