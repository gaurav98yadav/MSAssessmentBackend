package com.accoflow.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accoflow.dto.Course;
import com.accoflow.dto.Location;
import com.accoflow.dto.Year;
import com.accoflow.models.Trends;
import com.accoflow.rowmapper.CourseMapper;
import com.accoflow.rowmapper.LocationMapper;
import com.accoflow.rowmapper.YearMapper;

@Repository
public class TrendsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Trends displayTrends() {
		 String sql = "Select course, avg(final_marks) from assessment_details group by course";
		 List<Course> courses=jdbcTemplate.query(sql, new CourseMapper());
		 
		 sql="select grad_location,avg(final_marks) from assessment_details,grad_details where assessment_details.grad_id=grad_details.grad_id group by(grad_location)";
		 List<Location> locations=jdbcTemplate.query(sql, new LocationMapper());
		 
		 sql= "select grad_year,avg(final_marks) from assessment_details,grad_details where assessment_details.grad_id=grad_details.grad_id group by(grad_year)";
		 List<Year> years=jdbcTemplate.query(sql, new YearMapper());
		 Trends trends = new Trends();
		 trends.setCourses(courses);
		 trends.setLocations(locations);
		 trends.setYears(years);
		 return trends;
		 
	}
}
