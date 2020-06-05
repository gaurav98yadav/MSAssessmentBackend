package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.dto.Course;

public class CourseMapper implements RowMapper {
	
    
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Course course = new Course();
    	course.setCourse(rs.getString("course"));
    	course.setAverage(rs.getInt("avg(final_marks)"));
    	return course;
}

}
