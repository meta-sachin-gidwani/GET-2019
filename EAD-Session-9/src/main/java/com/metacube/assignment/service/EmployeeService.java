package com.metacube.assignment.service;

import java.util.List;

import com.metacube.assignment.dto.EmployeeForm;
import com.metacube.assignment.dto.VehicleForm;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.Image;
import com.metacube.assignment.model.Pass;

public interface EmployeeService {

	public abstract Status registerEmployee(EmployeeForm emp);

	public abstract boolean isEmpExist(String email);

	public abstract String getPasswordByEmail(String email);

	public abstract Status addVehicle(VehicleForm vehicle);

	public abstract Status addPass(Pass pass);

	public abstract Employee getEmpByEmail(String email);

	public abstract Status updateDetail(Employee emp);

	public abstract List<Employee> getFriendList(String email);

	public abstract Status updateImage(Image img);

	public abstract Status setImage(Image img);
}
