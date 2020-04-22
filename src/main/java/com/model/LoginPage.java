package com.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class LoginPage {
	
	@NotNull
	@Size(min=2,message="enter 2 to 10 character")
	private String usName;
	@NotNull
	@Size(min=5,message="enter minimum 5 character")
	String passwrd;
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	

}
