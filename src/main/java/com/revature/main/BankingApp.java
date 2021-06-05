package com.revature.main;

import java.util.Scanner;

public class BankingApp {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		boolean menu = true; 	// the main menu is on if true
		
		while (menu) {
			System.out.println("Welcome to the Bank of Ecelbarger\n" + "Choose any of the options below:");
			System.out.println("1.) Login\n" + "2.) Register\n" + "3.) Employee Login\n" + "4.) Quit");
			
			int ans = Integer.valueOf(scanner.nextLine());
			
			switch (ans) {
			case 1:
				// login();
				break;
			case 2:
				// register
				break;
			case 3:
				// loginEmployee();
				break;
			case 4:
				System.out.println("Thank you for stopping by! Enjoy your day.");
				menu = false;
				break;
				

			default:
				break;
			}
		}
		
		scanner.close();
	}
	
	private static void login() {
		loggedUser = us.login(scanner);
		
		if (loggedUser == null) {
			System.out.println("Incorrect Login, please try again");
		} else {
			
		}
	}
}
