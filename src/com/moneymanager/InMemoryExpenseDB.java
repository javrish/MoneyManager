package com.moneymanager;

import java.util.ArrayList;

public class InMemoryExpenseDB implements ExpenseDB{
	private ArrayList<Expense> expenseList;
	private double budget;
	public InMemoryExpenseDB() {
		expenseList = new ArrayList<Expense>();
		budget = 0;
	}
		
	public double getTotalExpense() {
		double totalExpense = 0;
		for(Expense e:expenseList) {
			totalExpense += e.getAmount();
		}
		return totalExpense;
	}

	public double getMonthlyExpense(String[] month) {
		double monthlyExpense = 0;
		String[] date;
		for(Expense e:expenseList) {
			date = e.getDate().split("[/]");
			if(Integer.parseInt(month[0]) == (Integer.parseInt(date[1])) && date[2].equals(month[1])) {
				monthlyExpense+= e.getAmount();
			}
		}
		return monthlyExpense;
	}

	@Override
	public boolean addExpense(Expense newExpense) {
		expenseList.add(newExpense);
		return true;
	}

	@Override
	public String getMonthlyExpenseList(String[] month) {
		String output="";
		String[] date;
		for(Expense e:expenseList) {
			date = e.getDate().split("[/]");
			if(Integer.parseInt(month[0]) == Integer.parseInt(date[1]) && date[2].equals(month[1])) {
				output+= e;
			}
		}
		
		return output;
	}

	@Override
	public String getAllExpenseList(String string) {
		String output="";
		for(Expense e:expenseList) {
				output+= e;
		}
		return output;
	}

	@Override
	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
}
