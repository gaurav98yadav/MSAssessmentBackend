package com.accoflow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accoflow.models.AnswerTable;
@Repository
public class AnswerDAO {
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public AnswerDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	public List<AnswerTable>getAllAnswers(int q_id)
	{
		String sql = "SELECT answer_table.ans_id,answer FROM question_answer_table,answer_table where question_answer_table.ans_id=answer_table.ans_id and question_answer_table.q_id="+q_id;
        List<AnswerTable> listQuestions = jdbcTemplate.query(sql, new RowMapper<AnswerTable>() {
     
            @Override
            public AnswerTable mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AnswerTable q = new AnswerTable();
            	q.setAnswerId(rs.getInt("ans_id"));
            	q.setAnswerValue(rs.getString("answer"));
            	q.setEmpId(rs.getInt("emp_id"));
//            	q.setEmpId(rs.getInt("emp_id"));
//            	q.setVote(rs.getInt("vote"));   
            	return q;
            }
     
        });

        return listQuestions;
	
	}

}
