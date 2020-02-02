package com.accoflow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.models.QuestionAnswer;

public class QuestionRowMapper implements RowMapper {

	@Override
	public QuestionAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionAnswer qa = new QuestionAnswer();
		qa.setQuestionValue(rs.getString("question"));
		qa.setDescription(rs.getString("description"));
		qa.setEmpName(rs.getString("name"));
		return qa;
	}

}
