package com.moneymanager;

public class CommandExecuter {
	ExpenseDB expenseDB;

	CommandExecuter() {
		expenseDB = new InMemoryExpenseDB();
	}

	public String execute(String command) {

		String[] input = command.split("[ ]");

		switch (input[0]) {
		case "create": {

			if (input.length != 4) {
				return "Invlid Syntax, Use : create <description> <amount> <date>";
			}
			if(input[3].length() != 10) {
				return "Date format incorrect";
			}
			
			double amount;
			try {
				amount = Double.parseDouble(input[2]);
			} catch (NumberFormatException e) {
				return "Invalid Amount";
			}
			Expense newExpense = new Expense();

			newExpense.setDescription(input[1]);
			newExpense.setAmount(amount);
			newExpense.setDate(input[3]);
			expenseDB.addExpense(newExpense);

			return "Expense of " + newExpense.getAmount() + " added on food";
		}
		case "show" : {
			
			if(input.length<3)
				return "Wrong syntax. Please use: show <property> <args>\n -all for total expense\n-month <month>for month wise";
			switch(input[1]) {
			case "-summary" : {

				switch (input[2]) {
				case "-all":
					return "Total Expense = " + expenseDB.getTotalExpense();

				case "-month": {
					if (input.length != 4) {
						return "Invalid Syntax, Use : status -month <Month Number>";
					}
					String month;
					String[] splitMonth = input[3].split("[/]");
					
					switch (Integer.parseInt(splitMonth[0])) {
					case 1: {
						month = "January";
						break;
					}
					case 2: {
						month = "February";
						break;
					}
					case 3: {
						month = "March";
						break;
					}
					case 4: {
						month = "April";
						break;
					}
					case 5: {
						month = "May";
						break;
					}
					case 6: {
						month = "June";
						break;
					}
					case 7: {
						month = "July";
						break;
					}
					case 8: {
						month = "August";
						break;
					}
					case 9: {
						month = "September";
						break;
					}
					case 10: {
						month = "October";
						break;
					}
					case 11: {
						month = "November";
						break;
					}

					case 12: {
						month = "December";
						break;
					}
					default: {
						return "Invalid Month";
					}

					}
					return month + "'s expense = " + expenseDB.getMonthlyExpense(splitMonth);
				}
				default: {
					return "Invalid property";
				}

				}
			}//end of -summary
			
			case "-list" :{
				switch(input[2]) {
				case "-month" : {
					String[] splitMonth = input[3].split("[/]"); 
					String output = expenseDB.getMonthlyExpenseList(splitMonth);
					return output;
				}
				case "-all" : {
					String output = expenseDB.getAllExpenseList(input[2]);
					return output;
				}
				default : {
					return "Invalid format,Use show -month <month number>";
				}
				}
				
			}//end of -list
			}//end of show's switch
			
			
		}//end of show
		case "budget" :{
			if(input.length <2) {
				return "Wrong syntax use: budget <properties> <args>";
			}
			switch(input[1]) {
			case "-set" : {
				double budget;
				try {
				budget = Double.parseDouble(input[2]);
				}catch(NumberFormatException e) {
					return "Please enter Valid Budget";
				}
				expenseDB.setBudget(budget);
				return "Budget set to "+expenseDB.getBudget();
			}
			
			case "-get" :
				return "Current Budget = "+expenseDB.getBudget();
			default : {
				return "Invalid Propert for budget";
			}
			}
			
		}
		default: {
			return "Invalid input";
		}
		}//end of commands switch
	}//end of main class

}//end of class