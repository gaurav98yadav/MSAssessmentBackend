package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.models.Trainer;

public class TrainerMapper implements RowMapper {	
	@Override
	public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException{   	
    	Trainer q = new Trainer();
    	q.setTrainer_id(rs.getInt("trainer_id"));
    	q.setTrainer_name(rs.getString("trainer_name"));
    	q.setTrainer_email(rs.getString("trainer_email"));
    	return q;
    }
}
