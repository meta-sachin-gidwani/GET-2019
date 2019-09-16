package com.metacube.assignment.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.dao.EmployeeDao;
import com.metacube.assignment.dao.Query;
import com.metacube.assignment.dto.EmployeeForm;
import com.metacube.assignment.dto.VehicleForm;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.mapper.EmployeeMapper;
import com.metacube.assignment.mapper.FriendMapper;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.Image;
import com.metacube.assignment.model.Pass;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Status registerEmployee(EmployeeForm emp) {
		int affectedRows = jdbcTemplate.update(Query.registerEmployee(),
				emp.getFullName(), emp.getGender(), emp.getEmail(),
				emp.getPassword(), emp.getContact(), emp.getOrganization());
		if (affectedRows > 0)
			return Status.REGISTERED;
		return Status.FAILED;
	}

	@Override
	public boolean isEmpExist(String email) {
		String empEmail=null;
		try {
			empEmail = jdbcTemplate.queryForObject(Query.findEmp(),
					new Object[] { email }, String.class);
		} catch (DataAccessException e) {
			return false;
		}
		if (!empEmail.equals(null))
			return true;
		return false;
	}

	@Override
	public String getPasswordByEmail(String email) {
		return jdbcTemplate.queryForObject(Query.getPassword(),new Object[]{email},String.class);
	}

	@Override
	public Status addVehicle(VehicleForm vehicle) {
		int affectedRows = jdbcTemplate.update(Query.addVehicle(),
				vehicle.getEmpId(), vehicle.getVehicleName(), vehicle.getVehicleType(),
				vehicle.getVehicleNumber(), vehicle.getIdentification());
		if (affectedRows > 0)
			return Status.ADDED;
		return Status.FAILED;
	}

	@Override
	public Status addPass(Pass pass) {
		int affectedRows = jdbcTemplate.update(Query.addPass(),pass.getEmpId(),pass.getPlanType(),pass.getPrice());
		if (affectedRows > 0)
			return Status.ADDED;
		return Status.FAILED;
	}

	@Override
	public Employee getEmpByEmail(String email) {
		return jdbcTemplate.queryForObject(Query.empDetailByEmail(),new Object[]{email},new EmployeeMapper());
	}

	@Override
	public Status updateDetail(Employee emp) {
		int affectedRows = jdbcTemplate.update(Query.updateDetail(),emp.getFullName(),emp.getGender(),emp.getContact(),emp.getVehicleName(),emp.getVehicleNumber(),emp.getIdentification(),emp.getEmail());
		if (affectedRows > 0)
			return Status.UPDATED;
		return Status.FAILED;
	}

	@Override
	public List<Employee> getFriendList(String email) {
		return jdbcTemplate.query(Query.getFriendsList(),new Object[]{email,email},new FriendMapper());
	}

	@Override
	public Status updateImage(Image img) {
		int affectedRows = jdbcTemplate.update(Query.updateImage(),img.getImageSrc(),img.getEmpId());
		if (affectedRows > 0)
			return Status.UPDATED;
		return Status.FAILED;
	}

	@Override
	public Status setImage(Image img) {
		int affectedRows = jdbcTemplate.update(Query.addImage(),img.getEmpId(),img.getImageSrc());
		if (affectedRows > 0)
			return Status.ADDED;
		return Status.FAILED;
	}

}
