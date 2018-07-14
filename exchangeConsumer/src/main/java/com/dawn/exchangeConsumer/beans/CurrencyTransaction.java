package com.dawn.exchangeConsumer.beans;

import java.util.Date;

import org.springframework.stereotype.Controller;

import com.dawn.exchangeConsumer.enums.CurrencyCode;

@Controller
public class CurrencyTransaction {

	private CurrencyCode currencyCode;
	private double amount;
	private Date sysdate;
	private String countryName;
	private double exchangeRateNIS;
	
	public CurrencyTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyTransaction(CurrencyCode currencyCode, double amount, Date sysdate) {
		super();
		this.currencyCode = currencyCode;
		this.amount = amount;
		this.sysdate = sysdate;
		this.countryName = "USA";
		this.exchangeRateNIS = 3.54;
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
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public double getExchangeRateNIS() {
		return exchangeRateNIS;
	}

	public void setExchangeRateNIS(double exchangeRateNIS) {
		this.exchangeRateNIS = exchangeRateNIS;
	}

	@Override
	public String toString() {
		return "CurrencyTransaction [currencyCode=" + currencyCode + ", amount=" + amount + ", sysdate=" + sysdate
				+ ", countryName=" + countryName + ", exchangeRateNIS=" + exchangeRateNIS + "]";
	}

}
