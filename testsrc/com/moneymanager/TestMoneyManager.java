package com.moneymanager;

public class TestMoneyManager {

	public static void main(String[] args) {
		TestMoneyManager test = new TestMoneyManager();
		test.expenseCreateTest();
		test.multipleExpenseCreateTest();
		test.getExpenseStatus();
		test.expenseCreateWithWrongSyntaxTest();
		test.expenseCreateWithInvlaidAmountTest();
		test.getMonthsExpenseTest();
		test.getMonthsAllExpenseList();
		test.showWithInvalidPropertiesShowErrorMessage();
		test.monthlyExpenseIsDifferentForDifferentYear();
		
		test.setBudgetTest();
		test.getBudgetTest();
		//System.out.println("".equals("1"));
		//test.getRemainingBudget();
		
		System.out.println("All testcases passed!");
	}

	private void getRemainingBudget() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create food 200 29/07/2017");
		executer.execute("create Sports 1200 29/07/2017");
		executer.execute("create Movie 1600 29/07/2017");
		executer.execute("create Taxes 10213.31 29/07/2017");
		executer.execute("budget -remain");
		
	}

	private void getBudgetTest() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("budget -set 20000");
		check(executer.execute("budget -get"),"Current Budget = 20000.0");
	}

	private void setBudgetTest() {
		CommandExecuter executer = new CommandExecuter();
		check(executer.execute("budget -set 20000"),"Budget set to 20000.0");
		
	}

	private void monthlyExpenseIsDifferentForDifferentYear() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create food 200 29/07/2017");
		executer.execute("create Sports 1200 29/07/2017");
		executer.execute("create Movie 1600 29/07/2017");
		executer.execute("create Taxes 10213.31 29/07/2017");
		check(executer.execute("show -summary -all"),"Total Expense = 13213.31");
	}

	private void showWithInvalidPropertiesShowErrorMessage() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create food 100 26/08/2019");
		executer.execute("create movie 300 27/08/2019");
		executer.execute("create social 500 28/08/2019");
		check(executer.execute("show"),"Wrong syntax. Please use: show <property> <args>\n" + 
				" -all for total expense\n" + 
				"-month <month>for month wise");
		
	}

	private void getMonthsAllExpenseList() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create food 100 26/08/2019");
		executer.execute("create movie 300 27/08/2019");
		executer.execute("create social 500 28/08/2019");
		
		check(executer.execute("show -list -month 8/2019"),"\nDescription: food\n" + 
				" Date: 26/08/2019\n" + 
				"Amount: 100.0\n" + 
				"Description: movie\n" + 
				" Date: 27/08/2019\n" + 
				"Amount: 300.0\n" + 
				"Description: social\n" + 
				" Date: 28/08/2019\n" + 
				"Amount: 500.0");
	}

	private void getMonthsExpenseTest() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create food 100 26/08/2019");
		executer.execute("create movie 300 26/08/2019");
		
		check(executer.execute("show -summary -month 8/2019"),"August's expense = 400.0");
	}

	private void expenseCreateWithInvlaidAmountTest() {
		CommandExecuter executer = new CommandExecuter();
		check(executer.execute("create 100 food 26/08/2019"),"Invalid Amount");
	}

	private void expenseCreateWithWrongSyntaxTest() {
		CommandExecuter executer = new CommandExecuter();
		check(executer.execute("create food 100 now 26/08/2019"),"Invlid Syntax, Use : create <description> <amount> <date>");
	}

	private void multipleExpenseCreateTest() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create movie 300.0 26/08/2019");
		executer.execute("create food 200.0 26/08/2019");
		check(executer.execute("show -summary -all"),"Total Expense = 500.0");
	}

	private void getExpenseStatus() {
		CommandExecuter executer = new CommandExecuter();
		executer.execute("create food 100.0 26/08/2019");
		check(executer.execute("show -summary -all"),"Total Expense = 100.0");
	}

	private void expenseCreateTest() {
		CommandExecuter executer = new CommandExecuter();
		check(executer.execute("create food 100.0 26/08/2019"),"Expense of 100.0 added on food");
	}

	private void check(String actual, String expected) {
		if(!actual.equals(expected)) {
			throw new RuntimeException(String.format("Expected : "+expected +"\n Recieved : "+actual));
		}
	}
}
