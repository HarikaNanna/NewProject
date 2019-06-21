package com.training.bean;

public class RegistrationBean {
	private String email;
	private String firstname;
	private String lastname;

	public RegistrationBean() {
	}

	public RegistrationBean(String email, String firstname, String lastname) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "RegistrationBean [email=" + email + ", firstname=" + firstname + " , lastname=" + lastname + "]";
	}

}
