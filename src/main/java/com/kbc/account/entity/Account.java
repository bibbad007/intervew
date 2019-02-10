package com.kbc.account.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String accountType;
	float balance;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "PERSON_ID")
	Person person;
	@OneToMany(mappedBy = "fromAccount")
	Set<Transaction> transactionFrom;
	@OneToMany(mappedBy = "toAccount")
	Set<Transaction> transactionTo;

	public Account() {		
	}

	public Account(String accountType, float balance, Person person, Set<Transaction> transactionFrom,
			Set<Transaction> transactionTo) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.person = person;
		this.transactionFrom = transactionFrom;
		this.transactionTo = transactionTo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<Transaction> getTransactionFrom() {
		return transactionFrom;
	}

	public void setTransactionFrom(Set<Transaction> transactionFrom) {
		this.transactionFrom = transactionFrom;
	}

	public Set<Transaction> getTransactionTo() {
		return transactionTo;
	}

	public void setTransactionTo(Set<Transaction> transactionTo) {
		this.transactionTo = transactionTo;
	}
  
}
