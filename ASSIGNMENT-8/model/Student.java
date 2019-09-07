package com.metacube.assignment.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class Student {

	@NotBlank(message = "{blankName}")
	@Size(min = 3, message = "{smallName}")
	@Size(max = 20, message = "{largeName}")
	private String firstName;

	@NotBlank(message = "{blankName}")
	@Size(min = 3, message = "{smallName}")
	@Size(max = 20, message = "{largeName}")
	private String lastName;

	@NotBlank(message = "{blankName}")
	@Size(min = 3, message = "{smallName}")
	@Size(max = 20, message = "{largeName}")
	private String fatherName;

	@NotBlank(message = "{blankName}")
	@Size(min = 6, message = "{smallName}")
	@Size(max = 40, message = "{largeName}")
	private String email;

	@NotNull(message = "{blankClass}")
	@Min(1)
	@Max(12)
	private int std;

	@NotNull(message = "{blankAge}")
	@Min(5)
	@Max(20)
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", email=" + email + ", std="
				+ std + ", age=" + age + "]";
	}
}
