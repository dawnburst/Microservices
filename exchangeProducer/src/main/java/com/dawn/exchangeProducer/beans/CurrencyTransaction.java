package com.dawn.exchangeProducer.beans;

import java.util.Date;

import org.springframework.stereotype.Controller;

import com.dawn.exchangeProducer.enums.CurrencyCode;

@Controller
public class CurrencyTransaction {

	private CurrencyCode currencyCode;
	private double amount;
	private Date sysdate;
	
	public CurrencyTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyTransaction(CurrencyCode currencyCode, double amount, Date sysdate) {
		super();
		this.currencyCode = currencyCode;
		this.amount = amount;
		this.sysdate = sysdate;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	@Override
	public String toString() {
		return "CurrencyTransaction [currencyCode=" + currencyCode + ", amount=" + amount + ", sysdate=" + sysdate
				+ "]";
	}
	
	
}
