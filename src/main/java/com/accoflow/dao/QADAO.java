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
import com.accoflow.models.QuestionAnswer;
import com.accoflow.rowmapper.QuestionRowMapper;

@Repository
public class QADAO {
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public QADAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	public QuestionAnswer getAnswers(int id)
	{
		String sqlSelectQuery ="Select question,description,name FROM question_table,employee  where employee.emp_id=question_table.emp_id and q_id=" + id;
		QuestionAnswer qa = (QuestionAnswer) jdbcTemplate.queryForObject(sqlSelectQuery,new QuestionRowMapper());
		String sql = "SELECT name,answer_table.ans_id,answer FROM employee,question_answer_table,answer_table where question_answer_table.ans_id=answer_table.ans_id and question_answer_table.q_id="+id+" and answer_table.emp_id=employee.emp_id";
        List<AnswerTable> listAnswers = jdbcTemplate.query(sql, new RowMapper<AnswerTable>() {
     
            @Override
            public AnswerTable mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AnswerTable q = new AnswerTable();
            	q.setAnswerId(rs.getInt("ans_id"));
            	q.setAnswerValue(rs.getString("answer"));
            	q.setEmpName(rs.getString("name"));
//            	q.setEmpId(rs.getInt("emp_id"));
//            	q.setVote(rs.getInt("vote"));   
            	return q;
            }
     
        });

         qa.setAnswerList(listAnswers);
         return qa;
	}

}
