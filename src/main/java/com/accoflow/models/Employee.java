package com.accoflow.models;

public class Employee {

	private int empId;
	private String name;
	private String email;
	public Employee(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
		this.empId=i;
		this.email=string2;
		this.name=string;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
