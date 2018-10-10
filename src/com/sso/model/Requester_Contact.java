package com.sso.model;

public class Requester_Contact {
	private int requesterId;
	private String name;
	private String phone;
	private String email;
	private String department;

	public int getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
