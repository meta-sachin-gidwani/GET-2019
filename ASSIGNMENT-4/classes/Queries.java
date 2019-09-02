package com.classes;

public class Queries {
	public static String getQueryForRegisterEmployee() {
		return "INSERT INTO EMPLOYEE(name, gender, email, password, contact_number, organization) VALUES(?, ?, ?, ?, ?, ?)";
	}
	
	public static String getQueryForAddVehicle() {
		return "INSERT INTO Vehicle(vehicle_name, type, vehicle_number, employee_Id, identification) VALUES(?, ?, ?, ?, ?)";
	}
	
	public static String getQueryForLogIn() {
		return "SELECT password FROM EMPLOYEE WHERE email = ? ";
	}
	
	public static String getQueryForEmpId() {
		return "SELECT max(regi_id) FROM EMPLOYEE";
	}
	
	public static String getQueryForAddPass() {
		return "INSERT INTO PASS(EMP_ID, PRICE) VALUES(?, ?)";
	}
	
	public static String getEmpId() {
		return "SELECT regi_id FROM EMPLOYEE WHERE email = ?";
	}
	
	public static String getQueryForEmpDetail() {
		return "SELECT e.regi_id, e.name, e.gender, e.email, e.contact_number, e.organization,"
				+ " v.vehicle_name, v.type, v.vehicle_number, v.identification, p.price FROM EMPLOYEE e, Vehicle v, PASS p"
				+ " WHERE v.employee_Id = ? and v.employee_Id = p.EMP_ID and e.regi_id = v.employee_Id";
	}
	
	public static String getQueryForFriendsList() {
		return "SELECT regi_id,name FROM EMPLOYEE WHERE regi_id != ? and organization ="
				+ " (select organization from EMPLOYEE where regi_id = ?)";
	}
}
