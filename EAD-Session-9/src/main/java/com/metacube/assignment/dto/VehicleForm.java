package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VehicleForm {
	private String empId;
	
	@NotBlank(message = "{blankName}")
	@Size(max = 30, message = "{largeName}")
	private String vehicleName;
	
	@NotNull(message="{vehicleTypeValidation}")
	private String vehicleType;
	
	@NotBlank(message = "{blankNumber}")
    @Size(min=4,max=12,message="{validNumber}")
	private String vehicleNumber;
	
	private String identification;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
