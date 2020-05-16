package com.moneymanager;
 interface ExpenseDB {
	boolean addExpense(Expense newExpense);
	double getTotalExpense();
	double getMonthlyExpense(String[] month);
	String getMonthlyExpenseList(String[] month);
	String getAllExpenseList(String string);
	double getBudget();
	void setBudget(double budget);
}
