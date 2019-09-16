package com.metacube.assignment.model;

public class Image {
	private String empId;
	private String imageSrc;
	
	public Image(String empId, String imageSrc) {
		super();
		this.empId = empId;
		this.imageSrc = imageSrc;
	}
	public Image() {
		// TODO Auto-generated constructor stub
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getImageSrc() {
		return imageSrc;
	}
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
	
}
