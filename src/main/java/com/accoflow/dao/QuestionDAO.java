package com.accoflow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accoflow.models.Employee;
import com.accoflow.models.QuestionTable;

@Repository
public class QuestionDAO {
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public QuestionDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	public List<QuestionTable>getAllQuestions(int id)
	{
		String sql = "SELECT * FROM question_table,employee_category where question_table.subcat_id=employee_category.subcat_id and employee_category.emp_id="+id;
        List<QuestionTable> listQuestions = jdbcTemplate.query(sql, new RowMapper<QuestionTable>() {
     
            @Override
            public QuestionTable mapRow(ResultSet rs, int rowNum) throws SQLException {
            	QuestionTable q = new QuestionTable();
            	q.setqId(rs.getInt("q_id"));
            	q.setQuestionValue(rs.getString("question"));
            	q.setDescription(rs.getString("description"));   
            	q.setVote(rs.getInt("vote"));   

            	
                return q;
            }
     
        });

        return listQuestions;
	
	}

}
