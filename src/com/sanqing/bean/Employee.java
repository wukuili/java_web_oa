package com.sanqing.bean;

import java.util.Date;

public class Employee {
	private int employeeID;
	private String employeeName;
	private Boolean employeeSex;
	private Date employeeBirth;
	private String employeePhone;
	private String employeePlace;
	private Date joinTime;
	private String password;
	private Boolean isLead;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Boolean getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(Boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(Date employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePlace() {
		return employeePlace;
	}
	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsLead() {
		return isLead;
	}
	public void setIsLead(Boolean isLead) {
		this.isLead = isLead;
	}
	
	
}
