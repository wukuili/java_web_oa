package com.sanqing.bean;

import java.util.Date;

public class Criticism {
	private int criticismID;
	private String criticismContent;
	private int messageID;
	private int employeeID;
	private Date criticismTime;
	public int getCriticismID() {
		return criticismID;
	}
	public void setCriticismID(int criticismID) {
		this.criticismID = criticismID;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}
	
}
