package com.accoflow.models;

public class AnswerTable {

	private int answerId;
	private String answerValue;
	private int vote;
	private int empId;
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswerValue() {
		return answerValue;
	}
	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	
}
