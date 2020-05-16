package com.moneymanager;

public class Expense {
	private double amount;
	private String description;
	private String date;
	
	public double getAmount() {
		return amount;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "\nDescription: "+description+"\n Date: "+date+"\nAmount: "+amount;
	}

}
