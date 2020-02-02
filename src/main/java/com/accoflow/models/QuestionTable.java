package com.accoflow.models;

public class QuestionTable {

	private int qId;
	private String questionValue;
	private int vote;
	private String description;
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getQuestionValue() {
		return questionValue;
	}
	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public void setDescription(String string) {
		// TODO Auto-generated method stub
		this.description=string;
		
	}
	public String getDescription() {
		return description;
	}
	
}
