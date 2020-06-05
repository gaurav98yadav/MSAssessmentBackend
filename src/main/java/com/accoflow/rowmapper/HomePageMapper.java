package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.models.Grad;

public class HomePageMapper implements RowMapper {
		

	@Override
	public Grad mapRow(ResultSet rs, int rowNum) throws SQLException {

		Grad grad = new Grad();
    	grad.setGrad_id(rs.getInt("grad_id"));
    	grad.setGrad_name(rs.getString("grad_name"));
    	grad.setGrad_location(rs.getString("grad_location"));   
    	grad.setGrad_college(rs.getString("grad_college"));   
    	grad.setGrad_year(rs.getInt("grad_year"));
    	int quiz_marks=rs.getInt("quiz_marks");
    	int quiz_graded=rs.getInt("quiz_graded");
    	if(quiz_graded==0)
    		grad.setQuiz_marks(0);
    	else
    		grad.setQuiz_marks(quiz_marks/quiz_graded);
    	int assignment_marks=rs.getInt("assignment_marks");
    	int assignment_graded=rs.getInt("assignment_graded");
    	if(assignment_graded==0)
    		grad.setAssignment_marks(0);
    	else
    		grad.setAssignment_marks(assignment_marks/assignment_graded); 
    	int project_marks=rs.getInt("project_marks");
    	int project_graded=rs.getInt("project_graded");
    	if(project_graded==0)
    		grad.setProject_marks(0);
    	else
    		grad.setProject_marks(project_marks/project_graded); 
    	
    	int mcq_marks=rs.getInt("mcq_marks");
    	int mcq_graded=rs.getInt("mcq_graded");
    	if(mcq_graded==0)
    		grad.setMcq_marks(0);
    	else
    		grad.setMcq_marks(mcq_marks/mcq_graded); 
    	return grad;		
	}
}
