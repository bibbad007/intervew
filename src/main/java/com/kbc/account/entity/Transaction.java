package com.kbc.account.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_from_account",query="select t from Transaction t where t.fromAccount.id = :pid")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@ManyToOne
	@JoinColumn(name = "FROM_ID")
	Account fromAccount;
	@ManyToOne
	@JoinColumn(name = "TO_ID")
	Account toAccount;
	Date transDate;
	float amountTrans;

	public Transaction() {
		super();
	}

	public Transaction(Account fromAccount, Account toAccount, Date transDate, float amountTrans) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transDate = transDate;
		this.amountTrans = amountTrans;
	}
    
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public float getAmountTrans() {
		return amountTrans;
	}

	public void setAmountTrans(float amountTrans) {
		this.amountTrans = amountTrans;
	}

}
