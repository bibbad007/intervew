package com.kbc.account.dto;

import java.util.HashSet;

public class PersonDto {
	long personId;
	String name;
	int age;
	String houseName;
	String houseLoc;
	int housePhone;
	String officeName;
	String officeLoc;
	int officePhone;
	HashSet<Long> accounts;
	String idProofType;

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseLoc() {
		return houseLoc;
	}

	public void setHouseLoc(String houseLoc) {
		this.houseLoc = houseLoc;
	}

	public int getHousePhone() {
		return housePhone;
	}

	public void setHousePhone(int housePhone) {
		this.housePhone = housePhone;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeLoc() {
		return officeLoc;
	}

	public void setOfficeLoc(String officeLoc) {
		this.officeLoc = officeLoc;
	}

	
	public int getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(int officePhone) {
		this.officePhone = officePhone;
	}

	public HashSet<Long> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashSet<Long> accounts) {
		this.accounts = accounts;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}
	

}
