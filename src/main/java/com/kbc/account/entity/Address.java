package com.kbc.account.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	String building;
	String location;
	int phone;
	
	public Address() {
		super();
	}

	public Address(String building, String location, int phone) {
		super();
		this.building = building;
		this.location = location;
		this.phone = phone;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
  
}
