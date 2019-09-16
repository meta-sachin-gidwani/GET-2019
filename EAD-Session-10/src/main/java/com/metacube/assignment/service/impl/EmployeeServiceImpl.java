package com.metacube.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment.dao.EmployeeDao;
import com.metacube.assignment.dto.EmployeeForm;
import com.metacube.assignment.dto.VehicleForm;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.Image;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao emplyoeeDao;

	@Override
	public Status registerEmployee(EmployeeForm emp) {
	   return emplyoeeDao.registerEmployee(emp);
	}

	@Override
	public boolean isEmpExist(String email) {
		return emplyoeeDao.isEmpExist(email);
	}

	@Override
	public String getPasswordByEmail(String email) {
		return emplyoeeDao.getPasswordByEmail(email);
	}

	@Override
	public Status addVehicle(VehicleForm vehicle) {
		return emplyoeeDao.addVehicle(vehicle);
	}

	@Override
	public Status addPass(Pass pass) {
		return emplyoeeDao.addPass(pass);
	}

	@Override
	public Employee getEmpByEmail(String email) {
		return emplyoeeDao.getEmpByEmail(email);
	}

	@Override
	public Status updateDetail(Employee emp) {
		return emplyoeeDao.updateDetail(emp);
	}

	@Override
	public List<Employee> getFriendList(String email) {
		return emplyoeeDao.getFriendList(email);
	}

	@Override
	public Status updateImage(Image img) {
		return emplyoeeDao.updateImage(img);
	}

	@Override
	public Status setImage(Image img) {
		return emplyoeeDao.setImage(img);
	}

}
