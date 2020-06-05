package com.accoflow.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accoflow.constants.Queries;
import com.accoflow.models.Grad;
import com.accoflow.rowmapper.HomePageMapper;


@Repository
public class HomeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Grad>displayGrads()
	{
        return jdbcTemplate.query(Queries.FETCH_GRAD_DETAILS, new HomePageMapper());
	}
	
}

