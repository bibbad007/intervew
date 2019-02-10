package com.kbc.account.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="PERSON")
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person implements Cloneable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column(name="NAME",nullable=false)
	String name;
	@Column(name="AGE")
	int age;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride (name="building",column=@Column(name="house_no")),
			@AttributeOverride (name="location",column=@Column(name="house_loc")),
			@AttributeOverride (name="phone",column=@Column(name="house_phone"))
	})
    Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride (name="building",column=@Column(name="office_no")),
			@AttributeOverride (name="location",column=@Column(name="office_loc")),
			@AttributeOverride (name="phone",column=@Column(name="office_phone"))
	})
    Address officeAddress;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="proof_id",unique=true)
	IdProof idProof;
	
	@OneToMany(mappedBy="person",fetch=FetchType.EAGER)
	private Set<Account> accounts;
	
	public Person() {		
	}	


	public Person(String name, int age, Address string, Address string2, IdProof i,
			Set<Account> accounts) {
		super();
		this.name = name;
		this.age = age;
		this.homeAddress = string;
		this.officeAddress = string2;
		this.idProof = i;
		this.accounts = accounts;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAdress) {
		this.officeAddress = officeAdress;
	}

	public IdProof getIdProof() {
		return idProof;
	}

	public void setIdProof(IdProof idProof) {
		this.idProof = idProof;
	}


	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}	

}
