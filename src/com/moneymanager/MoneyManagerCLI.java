package com.moneymanager;

import java.util.Scanner;

public class MoneyManagerCLI {

	public static void main(String[] args) {
		CommandExecuter executer = new CommandExecuter();
		String command;
		Scanner sc = new Scanner(System.in);
		while (!(command = sc.nextLine()).equals("q")) {
			System.out.println(executer.execute(command));
		}
		sc.close();
	}

}
