package com.metacube.assignment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.model.Employee;


public class EmployeeMapper  implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		Employee emp=new Employee();
		if(resultSet != null){
		emp.setFullName(resultSet.getString("name"));
		emp.setGender(resultSet.getString("gender"));
		emp.setEmail(resultSet.getString("email"));
		emp.setContact(resultSet.getString("contact_number"));
		emp.setOrganization(resultSet.getString("organization"));
		emp.setVehicleName(resultSet.getString("vehicle_name"));
		emp.setVehicleType(resultSet.getString("type"));
		emp.setVehicleNumber(resultSet.getString("vehicle_number"));
		emp.setIdentification(resultSet.getString("identification"));
		emp.setPlanType(resultSet.getString("planType"));
		emp.setPrice(resultSet.getString("price"));
		emp.setImage(resultSet.getString("imageSrc"));
		}
		return emp;
	}

}
