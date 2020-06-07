package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.models.Assessment;

public class AssessmentMapper implements RowMapper {
	
    @Override
    public Assessment mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Assessment assessment = new Assessment();
    	assessment.setCourse(rs.getString("course"));
    	assessment.setTest_name(rs.getString("test_name"));
    	assessment.setAssessment_type(rs.getInt("assessment_type"));
    	assessment.setFinal_marks(rs.getInt("final_marks"));
    	return assessment;
}

}
