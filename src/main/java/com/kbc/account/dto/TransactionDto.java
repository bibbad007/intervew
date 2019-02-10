package com.kbc.account.dto;

import java.util.Date;

import com.kbc.account.entity.Account;

public class TransactionDto {
	long id;
	long accountIdFrom;
	long accountIdTo;
	Date transDate;
	float amountTrans;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAccountIdFrom() {
		return accountIdFrom;
	}
	public void setAccountIdFrom(long accountIdFrom) {
		this.accountIdFrom = accountIdFrom;
	}
	public long getAccountIdTo() {
		return accountIdTo;
	}
	public void setAccountIdTo(long accountIdTo) {
		this.accountIdTo = accountIdTo;
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
