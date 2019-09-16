package com.metacube.assignment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.model.Employee;

public class FriendMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		Employee emp=new Employee();
		emp.setEmail(resultSet.getString("email"));
		emp.setFullName(resultSet.getString("name"));
		return emp;
	}
}
