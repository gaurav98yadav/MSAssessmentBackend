package com.accoflow.models;

import java.util.List;

public class QuestionAnswer {

	private int qId;
	private String questionValue;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private String empName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<AnswerTable> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<AnswerTable> answerList) {
		this.answerList = answerList;
	}
	private List<AnswerTable> answerList;
}
