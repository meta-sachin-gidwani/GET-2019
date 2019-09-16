package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeForm {

	@NotBlank(message = "{blankName}")
	@Size(max = 30, message = "{largeName}")
	@Pattern(regexp = "[A-z a-z]*",message="{validName}")
	private String fullName;
	
	@NotNull(message="{genderRequired}")
	private String gender;
	
	@NotBlank(message = "{blankEmail}")
	@Size(max = 40, message = "{largeEmail}")
	private String email;
	
	@Size(max = 40, message = "{largePassword}")
	@Pattern(regexp = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}", message="{validPassword}")
	private String password;
	
	@NotBlank(message = "{blankPassword}")
	private String confirmPassword;
	
	@NotBlank(message = "{blankNumber}")
    @Size(min=10,max=10,message="{validNumber}")
	private String contact;
	
	@NotNull(message="{organizationRequired}")
	private String organization;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
