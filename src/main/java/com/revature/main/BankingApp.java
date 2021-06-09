package com.revature.main;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.services.*;

public class BankingApp {
	private static Scanner scanner = new Scanner(System.in);

	private static Customer loggedCustomer;
	private static Employee loggedEmployee;
	private static Integer loggedId;
	private static boolean menu;
	private static boolean cOptions;
	private static boolean eOptions;

	private static CustomerService cs = new CustomerServiceImpl();
	private static EmployeeService es = new EmployeeServiceImpl();
	private static TransactionService ts = new TransactionServiceImpl();
	private static AccountService as = new AccountServiceImpl();

	public static void main(String[] args) {
		BasicConfigurator.configure();
		scanner = new Scanner(System.in);

		menu = true;

		while (menu) {
			System.out.println("Welcome to the Bank of Ecelbarger\n" + "Choose any of the options below:");
			System.out.println("1.) Login\n" + "2.) Register\n" + "3.) Employee Login\n" + "4.) Quit");

			int ans = Integer.valueOf(scanner.nextLine());

			switch (ans) {
			case 1:
				menu = false;
				login();
				break;
			case 2:
				menu = false;
				cs.register(scanner);
				menu = true;
				break;
			case 3:
				menu = false;
				loginEmployee();
				break;
			case 4:
				System.out.println("Thank you for stopping by! Enjoy your day.");
				menu = false;
				break;

			default:
				System.out.println("Invalid input, please try again.\n");
				break;
			}
		}

		scanner.close();
	}

	private static void login() {
		loggedCustomer = cs.login(scanner);

		if (loggedCustomer == null) {
			System.out.println("Incorrect Login, please try again\n");
			menu = true;
		} else {
			System.out.println("Login successfull!\n");
			loggedId = loggedCustomer.getId();
			customerOptions();
		}
	}

	private static void loginEmployee() {
		loggedEmployee = es.login(scanner);

		if (loggedEmployee == null) {
			System.out.println("Incorrect Login, please try again");
			menu = true;
		} else {
			System.out.println("Login successfull!\n");
			employeeOptions();
		}
	}

	private static void customerOptions() {

		cOptions = true;

		while (cOptions) {
			System.out.println("Choose any of the options below:\n");
			System.out.println("1.) View Account Balance\n" + "2.) View Your Transactions\n" + "3.) Transfer Money\n" + "4.) Deposit\n" + "5.) Withdraw\n" + "6.) Logout\n");

			int ans = Integer.valueOf(scanner.nextLine());

			switch (ans) {
			case 1:
				// Ask if checking or saving
				System.out.println("Do you want the balance of your checking or savings account?(c/s)\n");
				String aC = scanner.nextLine();
				
				if (aC.equals("c")) {
					System.out.println(as.viewBalance(loggedId, "checking"));		
				} else if (aC.equals("s")) {
					System.out.println(as.viewBalance(loggedId, "saving"));
				} else {
					System.out.println("Please enter c or s. For checking or saving respectively.\n");
				}
				break;
			case 2:
				System.out.println(ts.viewCustomerTransactions(loggedId));
				break;
			case 3:
				cOptions = false;
				ts.transfer(scanner, loggedId);
				cOptions = true;
				break;
			case 4:
				cOptions = false;
				ts.deposit(scanner, loggedId);
				cOptions = true;
				break;
			case 5:
				cOptions = false;
				ts.withdraw(scanner, loggedId);
				cOptions = true;
				break;
			case 6:
				System.out.println("Returning to the main menu.\n");
				loggedId = 0;
				cOptions = false;
				menu = true;
				break;

			default:
				System.out.println("Invalid input, please try again.\n");
				break;
			}
		}

	}

	private static void employeeOptions() {

		eOptions = true;

		while (eOptions) {
			System.out.println("Choose any of the options below:\n");
			System.out.println("1.) View Customer Account\n" + "2.) View All Transactions\n"
					+ "3.) View All Customers\n" + "4.) Verify Customer\n" + "5.) Verify Transaction\n" + "6.) Logout");

			int ans = Integer.valueOf(scanner.nextLine());

			switch (ans) {
			case 1:
				Customer viewedCustomer = es.viewCustomerAccount(scanner);
				System.out.println(viewedCustomer);
				break;
			case 2:
				System.out.println(es.viewAllTransactions());
				break;
			case 3:
				System.out.println(es.getCustomers());
				break;
			case 4:
				System.out.println("Please enter the id of the Customer you wish to verify: ");
				Integer cid = Integer.valueOf(scanner.nextLine());
				System.out.println(es.verifyCustomer(cid));
				break;
			case 5:
				System.out.println("Please enter the id of the transaction you wish to verify: ");
				Integer tid = Integer.valueOf(scanner.nextLine());
				System.out.println(es.verifyTransaction(tid));
				break;
			case 6:
				System.out.println("Returning to the main menu.\n");
				eOptions = false;
				menu = true;
				break;

			default:
				System.out.println("Invalid input, please try again.\n");
				break;
			}
		}
	}
}
