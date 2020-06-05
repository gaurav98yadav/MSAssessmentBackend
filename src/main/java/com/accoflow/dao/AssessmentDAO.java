package com.accoflow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accoflow.constants.Queries;
import com.accoflow.models.Assessment;
import com.accoflow.models.Project;

@Repository
public class AssessmentDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	   public boolean checkDuplicates(Assessment assessment)
	   {
		   try{
			   jdbcTemplate.queryForObject(Queries.DUPLICATE_CHECK,new Object[] {assessment.getGrad_id(),assessment.getCourse(),assessment.getTest_name(),assessment.getAssessment_type()},Integer.class);
		   }
		   catch(EmptyResultDataAccessException e)
		   {
			   return true;		   
		   }
			   return false;
	   }
	   public boolean quiz(Assessment assessment)
	   {
		   	  try{jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,assessment.getGrad_id(),assessment.getTrainer_id(),assessment.getFinal_marks(),assessment.getTrainer_feedback(),assessment.getAssessment_type(),assessment.getCourse(),assessment.getTest_name());}
		      catch(DataAccessException e)
		   	  {
		    	  return false;
		   	  }
		   	  int totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_QUIZ, new Object[] {assessment.getGrad_id()}, Integer.class);
		      if(totalQuiz==0)
		      {
		    	  totalQuiz++;
		    	  jdbcTemplate.update(Queries.UPDATE_QUIZ,totalQuiz,assessment.getFinal_marks(),assessment.getGrad_id());
		    	  return true;
		      }
		      else
		      {
		    	  totalQuiz++;
			      int quiz_marks = jdbcTemplate.queryForObject(Queries.GET_QUIZ_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		    	  jdbcTemplate.update(Queries.UPDATE_QUIZ,totalQuiz,(assessment.getFinal_marks()+quiz_marks),assessment.getGrad_id());
			      return true;
		      }
	   }
	   public boolean mcq(Assessment assessment)
	   {
		   try {
		      jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,assessment.getGrad_id(),assessment.getTrainer_id(),assessment.getFinal_marks(),assessment.getTrainer_feedback(),assessment.getAssessment_type(),assessment.getCourse(),assessment.getTest_name());
		   }
		   catch(DataAccessException e)
		   	  {
		    	  return false;
		   	  }
		      int totalMCQ = jdbcTemplate.queryForObject(Queries.GET_TOTAL_MCQ, new Object[] {assessment.getGrad_id()}, Integer.class);
		      if(totalMCQ==0)
		      {
		    	  totalMCQ++;
		    	  jdbcTemplate.update(Queries.UPDATE_MCQ,totalMCQ,assessment.getFinal_marks(),assessment.getGrad_id());
		    	  return true;
		      }
		      else
		      {
		    	  totalMCQ++;
			      int quiz_marks = jdbcTemplate.queryForObject(Queries.GET_MCQ_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		    	  jdbcTemplate.update(Queries.UPDATE_MCQ,totalMCQ,(assessment.getFinal_marks()+quiz_marks),assessment.getGrad_id());
			      return true;
		      }
	   }
	   public boolean assignment(Assessment assessment)
	   {
		   try {
			      jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,assessment.getGrad_id(),assessment.getTrainer_id(),assessment.getFinal_marks(),assessment.getTrainer_feedback(),assessment.getAssessment_type(),assessment.getCourse(),assessment.getTest_name());
			   }
			   catch(DataAccessException e)
			   	  {
			    	  return false;
			   	  }
		      int totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_ASSIGNMENT, new Object[] {assessment.getGrad_id()}, Integer.class);
		      if(totalQuiz==0)
		      {
		    	  totalQuiz++;
		    	  jdbcTemplate.update(Queries.UPDATE_ASSIGNMENT,totalQuiz,assessment.getFinal_marks(),assessment.getGrad_id());
		    	  return true;
		      }
		      else
		      {
		    	  totalQuiz++;
			      int quiz_marks = jdbcTemplate.queryForObject(Queries.GET_ASSIGNMENT_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		    	  jdbcTemplate.update(Queries.UPDATE_ASSIGNMENT,totalQuiz,(assessment.getFinal_marks()+quiz_marks),assessment.getGrad_id());
			      return true;
		      }
	   }

	    public boolean project(Assessment assessment)
		   {
	    		 try 
	    		 {
			      jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,assessment.getGrad_id(),assessment.getTrainer_id(),assessment.getFinal_marks(),assessment.getTrainer_feedback(),assessment.getAssessment_type(),assessment.getCourse(),assessment.getTest_name());
	    		 }
			     catch(DataAccessException e)
			   	 {
			    	  return false;
			   	 }
			      int assessmentId =jdbcTemplate.queryForObject(Queries.DUPLICATE_CHECK,new Object[] {assessment.getGrad_id(),assessment.getCourse(),assessment.getTest_name(),assessment.getAssessment_type()},Integer.class);
			      int totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_PROJECT, new Object[] {assessment.getGrad_id()}, Integer.class);
			      if(totalQuiz==0)
			      {
			    	  totalQuiz++;
			    	  jdbcTemplate.update(Queries.UPDATE_PROJECT,totalQuiz,assessment.getFinal_marks(),assessment.getGrad_id());
			      }
			      else
			      {
			    	  totalQuiz++;
				      int quiz_marks = jdbcTemplate.queryForObject(Queries.GET_PROJECT_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
			    	  jdbcTemplate.update(Queries.UPDATE_PROJECT,totalQuiz,(assessment.getFinal_marks()+quiz_marks),assessment.getGrad_id());
			      }
				    jdbcTemplate.update(Queries.INSERT_PROJECT,assessmentId,assessment.getBuild_marks(),assessment.getTesting_marks(),assessment.getProcess_marks());
				    return true;
		   }
	public List<Assessment> fetchAssessments(int id) {
		return jdbcTemplate.query(Queries.FETCH_ASSIGNMENTS, new Object[] {id}, new RowMapper<Assessment>() {
		                 
			public Assessment mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Assessment assessment = new Assessment();
            	assessment.setAssessment_id(rs.getInt("assessment_id"));
            	assessment.setGrad_id(rs.getInt("grad_id"));
            	assessment.setTrainer_id(rs.getInt("trainer_id"));   
            	assessment.setFinal_marks(rs.getInt("final_marks"));   
            	assessment.setTrainer_feedback(rs.getString("trainer_feedback"));
            	assessment.setGrad_name(rs.getString("grad_name"));
            	assessment.setTest_name(rs.getString("test_name"));
            	assessment.setCourse(rs.getString("course"));
            	if(id==4)
            	{
            		@SuppressWarnings("unchecked")
					Project p = (Project) jdbcTemplate.queryForObject(Queries.FETCH_PROJECTS,new Object[] {assessment.getAssessment_id()}, new BeanPropertyRowMapper(Project.class));
            		assessment.setBuild_marks(p.getBuild_marks());
            		assessment.setTesting_marks(p.getTesting_marks());
            		assessment.setProcess_marks(p.getProcess_marks());
            	}
                return assessment;
            }
     
        });	
	}
	public String editAssessment(Assessment assessment) {
		int quiz_marks;
		  int old_marks=jdbcTemplate.queryForObject(Queries.FETCH_OLD_MARKS,new Object[] {assessment.getAssessment_id()}, Integer.class);
	      jdbcTemplate.update(Queries.UPDATE_ASSESSMENT,assessment.getFinal_marks(),assessment.getTrainer_feedback(),assessment.getAssessment_id());
	      switch(assessment.getAssessment_type())
	      {
	      case 1:
		      quiz_marks = jdbcTemplate.queryForObject(Queries.GET_QUIZ_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.EDIT_QUIZ,(quiz_marks-old_marks+assessment.getFinal_marks()),assessment.getGrad_id());
		      return "snvcd";
	      case 2:
	    	   quiz_marks = jdbcTemplate.queryForObject(Queries.GET_MCQ_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.EDIT_MCQ,(quiz_marks-old_marks+assessment.getFinal_marks()),assessment.getGrad_id());
		      return "success";
	      case 3:
	    	   quiz_marks = jdbcTemplate.queryForObject(Queries.GET_ASSIGNMENT_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.EDIT_ASSIGNMENT,(quiz_marks-old_marks+assessment.getFinal_marks()),assessment.getGrad_id());
		      return "success";
	      case 4:
	    	  quiz_marks = jdbcTemplate.queryForObject(Queries.GET_PROJECT_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.EDIT_PROJECT,(quiz_marks-old_marks+assessment.getFinal_marks()),assessment.getGrad_id());
		      jdbcTemplate.update(Queries.EDIT_PROJECT_MARKS,assessment.getBuild_marks(),assessment.getProcess_marks(),assessment.getTesting_marks(),assessment.getAssessment_id());
		      return "success";
	    	default:
	    		return "fail";
	      }
	}
	
	public String deleteAssessment(Assessment assessment)
	{
	      jdbcTemplate.update(Queries.DELETE_ASSESSMENT,assessment.getAssessment_id());
	      int quiz_marks,totalQuiz;
	      switch(assessment.getAssessment_type())
	      {
	      case 1:
		       quiz_marks = jdbcTemplate.queryForObject(Queries.GET_QUIZ_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		       totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_QUIZ, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.UPDATE_QUIZ,totalQuiz-1,quiz_marks-assessment.getFinal_marks(),assessment.getGrad_id());
		      return "success";

	      case 2:
	    	  quiz_marks = jdbcTemplate.queryForObject(Queries.GET_MCQ_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		       totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_MCQ, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.UPDATE_MCQ,totalQuiz-1,quiz_marks-assessment.getFinal_marks(),assessment.getGrad_id());
		      return "success";

	      case 3:
	    	  quiz_marks = jdbcTemplate.queryForObject(Queries.GET_ASSIGNMENT_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		       totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_ASSIGNMENT, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.UPDATE_ASSIGNMENT,totalQuiz-1,quiz_marks-assessment.getFinal_marks(),assessment.getGrad_id());
		      return "success";

	      case 4:
		      jdbcTemplate.update(Queries.DELETE_PROJECT,assessment.getAssessment_id());
		      quiz_marks = jdbcTemplate.queryForObject(Queries.GET_PROJECT_MARKS, new Object[] {assessment.getGrad_id()}, Integer.class);
		       totalQuiz = jdbcTemplate.queryForObject(Queries.GET_TOTAL_PROJECT, new Object[] {assessment.getGrad_id()}, Integer.class);
		      jdbcTemplate.update(Queries.UPDATE_PROJECT,totalQuiz-1,quiz_marks-assessment.getFinal_marks(),assessment.getGrad_id());
		      return "success";
		   default:
			      return "fail";

	      }
	}
	   
}
