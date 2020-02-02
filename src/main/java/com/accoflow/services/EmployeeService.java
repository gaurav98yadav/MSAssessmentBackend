package com.accoflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accoflow.dao.EmployeeDAO;
import com.accoflow.models.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO dao;
	
	public List<Employee>getAlLEmployees(){
		return dao.getAllEmployees();
	}

}
