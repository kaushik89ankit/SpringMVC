package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotEmpty;

public class UserDetailsRequestModel {

	@NotEmpty(message = "First Name may not be empty")
	private String firstName;
	private String lastName;
	@NotEmpty(message = "Email can not be empty")
	private String email;
	@NotEmpty(message = "Password can not be empty")
	private String password;

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

}
