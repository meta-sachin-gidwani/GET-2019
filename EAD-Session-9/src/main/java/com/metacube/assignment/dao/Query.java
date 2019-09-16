package com.metacube.assignment.dao;

public class Query {

	public static String registerEmployee() {
		return "INSERT INTO EMPLOYEE(name, gender, email, password, contact_number, organization) VALUES(?, ?, ?, ?, ?, ?)";
	}

	public static String findEmp() {
		return "SELECT email FROM EMPLOYEE WHERE email = ?";
	}

	public static String getPassword() {
		return "SELECT password FROM EMPLOYEE WHERE email = ?";
	}

	public static String addVehicle() {
		return "INSERT INTO VEHICLE VALUES(?, ?, ?, ?, ?)";
	}


	public static String addImage() {
		return "INSERT INTO IMAGE VALUES(?, ?)";
	}
	
	public static String addPass() {
		return "INSERT INTO PASS VALUES(?, ?, ?)";
	}

	public static String empDetailByEmail() {
		return "SELECT email,name,gender,contact_number,organization,vehicle_name,type,vehicle_number,identification,planType,price,imageSrc FROM EMPLOYEE,Vehicle,pass,image WHERE email = ? and email=employee_Id and email=emp_id and email=empId";
	}

	public static String updateDetail() {
		return "UPDATE EMPLOYEE,vehicle SET name=?,gender=?,contact_number=?,vehicle_name=?,vehicle_number=?,identification=? where email=? and email=employee_Id";
	}
	
	public static String getFriendsList() {
		return "SELECT email,name FROM EMPLOYEE WHERE email != ? and organization =(SELECT ORGANIZATION FROM EMPLOYEE WHERE EMAIL=?)";
	}

	public static String updateImage() {
		return "UPDATE IMAGE SET imageSrc=? WHERE empId=?";
	}
}
