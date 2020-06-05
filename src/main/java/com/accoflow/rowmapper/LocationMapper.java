package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.dto.Location;

public class LocationMapper implements RowMapper {
	
	@Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Location location = new Location();
    	location.setLocation(rs.getString("grad_location"));
    	location.setAverage(rs.getInt("avg(final_marks)"));
    	return location;
}

}
