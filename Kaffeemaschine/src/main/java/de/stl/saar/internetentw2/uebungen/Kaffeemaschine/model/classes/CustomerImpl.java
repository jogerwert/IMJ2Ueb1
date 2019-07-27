package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.classes;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.interfaces.Customer;

public class CustomerImpl implements Customer {
	private Long customerId;
	private String firstName;
	private String lastName;
	
	public CustomerImpl(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public CustomerImpl(Long customerId, String firstName, String lastName) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public Long getCustomerId() {
		return customerId;
	}

	@Override
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
