package com.servlets;
public class Queries {
	public static String getQueryForAddStudent() {
		return "INSERT INTO STUDENT_DETAIL VALUES(?, ?, ?, ?, ?, ?)";
	}

	public static String getQueryForShowStudents() {
		return "SELECT * FROM STUDENT_DETAIL";
	}
	
	public static String getQueryForUpdateDetail(){
		return "UPDATE STUDENT_DETAIL SET FIRST_NAME = ? , LAST_NAME = ? , FATHER_NAME = ? , CLASS = ? , AGE = ? WHERE EMAIL = ?";
	}
	
	public static String getQueryForSearchStudentByName(){
		return "SELECT * FROM STUDENT_DETAIL WHERE first_name = ? AND last_name = ?";
	}
	
	public static String getQueryForSearchStudentByClass(){
		return "SELECT * FROM STUDENT_DETAIL WHERE class = ?";
	}
}
