package com.accoflow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accoflow.models.Employee;

@Repository
public class EmployeeDAO {
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	public List<Employee>getAllEmployees()
	{
		String sql = "SELECT * FROM employee";
        List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {
     
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Employee employee_obj = new Employee();
     
            	employee_obj.setEmpId(rs.getInt("emp_id"));
            	employee_obj.setName(rs.getString("name"));
            	employee_obj.setEmail(rs.getString("email"));
     
                return employee_obj;
            }
     
        });

        return listEmployee;
	
	}

}
