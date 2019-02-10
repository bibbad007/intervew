package com.kbc.account.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ID_PROOF")
public class IdProof {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String proofType;
	Date expiryDate;
	@OneToOne(mappedBy="idProof")
	Person person;
	
	
	
	public IdProof() {
		
	}
	
	public IdProof(String proofType, Person person,Date expiryDate) {
		super();
		this.proofType = proofType;
		this.person = person;
		this.expiryDate = expiryDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProofType() {
		return proofType;
	}
	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}	

}
