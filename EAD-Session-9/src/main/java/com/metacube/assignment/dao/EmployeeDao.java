package com.metacube.assignment.dao;

import java.util.List;

import com.metacube.assignment.dto.EmployeeForm;
import com.metacube.assignment.dto.VehicleForm;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.Image;
import com.metacube.assignment.model.Pass;

public interface EmployeeDao {

	/**
	 * method for register employee
	 * @param emp employee for registration
	 * @return status of register
	 */
	public Status registerEmployee(EmployeeForm emp);

	/**
	 * method for find employee existance
	 * @param email of employee
	 * @return true if employee exist else false
	 */
	public boolean isEmpExist(String email);

	/**
	 * method for get password by email of employee
	 * @param email of employee
	 * @return password of employee
	 */
	public String getPasswordByEmail(String email);

	/**
	 * method for add Vehicle
	 * @param vehicle for add
	 * @return status of add
	 */
	public Status addVehicle(VehicleForm vehicle);

	/**
	 * method for add pass of employee
	 * @param pass for add
	 * @return status of add
	 */
	public Status addPass(Pass pass);

	/**
	 * method for find employee by email
	 * @param email of employee
	 * @return employee detail
	 */
	public Employee getEmpByEmail(String email);

	/**
	 * method for update employee details
	 * @param emp employee
	 * @return status of update
	 */
	public Status updateDetail(Employee emp);

	/**
	 * method for get friend list of employee
	 * @param email of employee
	 * @return list of friends
	 */
	public List<Employee> getFriendList(String email);

	/**
	 * method for update image of employee
	 * @param img image for update
	 * @return status of update
	 */
	public Status updateImage(Image img);

	/**
	 * method for add image of employee
	 * @param img image for add
	 * @return status of add
	 */
	public Status setImage(Image img);
	
}
