package com.autos.elbuenconductor.springbatch.configuration;

import java.io.Serializable;

public class Trayecto implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private String firstName;
	private String lastName;

	public Trayecto() {
		
	}
	
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
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}