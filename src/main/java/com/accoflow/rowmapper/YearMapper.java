package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.dto.Year;

public class YearMapper implements RowMapper {

    
    @Override
    public Year mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Year year = new Year();
    	year.setYear(rs.getInt("grad_year"));
    	year.setAverage(rs.getInt("avg(final_marks)"));
    	return year;
}
}
