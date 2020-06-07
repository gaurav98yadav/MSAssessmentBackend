package com.accoflow.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accoflow.constants.Queries;
import com.accoflow.dto.Scorecard;
import com.accoflow.models.Assessment;
import com.accoflow.models.Grad;
import com.accoflow.rowmapper.AssessmentMapper;
import com.accoflow.rowmapper.HomePageMapper;


@Repository
public class HomeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Grad>displayGrads()
	{
        return jdbcTemplate.query(Queries.FETCH_GRAD_DETAILS, new HomePageMapper());
	}

	public Scorecard profile(int id) {
		List<Grad> gud = jdbcTemplate.query(Queries.FETCH_STUDENT,new Object[]{id}, new HomePageMapper());
		Grad grad = gud.get(0);
		grad.setTotal_marks((grad.getQuiz_marks()*0.2)+(grad.getProject_marks()*0.5)+(grad.getAssignment_marks()*0.2)+(grad.getMcq_marks()*0.1));
		List<Assessment>ass =jdbcTemplate.query(Queries.FETCH_SCORECARD, new Object[] {id}, new AssessmentMapper());
		Scorecard sc= new Scorecard();
		sc.setGrad(grad);
		sc.setAssessments(ass);
		String sql1 = "select count(*) from grad_details where grad_location = (Select grad_location from grad_details where grad_id=?)";
		String sql2 = "select count(*) from grad_details,student_marks where grad_details.grad_id = student_marks.grad_id and grad_location = (Select grad_location from grad_details where grad_id=?) and final_marks <(select final_marks from student_marks where grad_id=?) and grad_year=(select grad_year from grad_details where grad_id=?)";
		String sql3 ="select count(*) from grad_details,student_marks where grad_details.grad_id = student_marks.grad_id and grad_location = (Select grad_location from grad_details where grad_id=?) and final_marks =(select final_marks from student_marks where grad_id=?) and grad_year=(select grad_year from grad_details where grad_id=?)";
		int total_students=jdbcTemplate.queryForObject(sql1,new Object[] {id},Integer.class);
		int less_students=jdbcTemplate.queryForObject(sql2,new Object[] {id,id,id},Integer.class);
		int equal_students=jdbcTemplate.queryForObject(sql3,new Object[] {id,id,id},Integer.class)-1;
		System.out.println(total_students);
		System.out.println(less_students);
		System.out.println(equal_students);

		sc.setLocationpercentile(100*((less_students+(0.5*equal_students))/total_students));
		return sc;
	}
	
}

