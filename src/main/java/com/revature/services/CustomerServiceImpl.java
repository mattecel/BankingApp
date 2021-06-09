package com.revature.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.data.CustomerRepo;
import com.revature.data.CustomerRepoImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepo ca = new CustomerRepoImpl();

	@Override
	public Customer login(Scanner scanner) {
		System.out.println("Please enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		return ca.getCustomer(username, password);
	}

	@Override
	public void register(Scanner scanner) {
		List<Account> accounts = new ArrayList<Account>();
		Customer c = new Customer();

		// this customer will be pending until an employee confirms them
		c.setStatus("pending");

		System.out.println("Please enter an username for your account: ");
		c.setUsername(scanner.nextLine());
		System.out.println("Please enter a password for your account: ");
		c.setPassword(scanner.nextLine());
		System.out.println("Please enter your first name: ");
		c.setFirst(scanner.nextLine());
		System.out.println("Please enter your last name: ");
		c.setLast(scanner.nextLine());
		
		Account checking = new Account();
		checking.setType("checking");
		System.out.println("Please enter how much you would like to store in your checking account: ");
		BigDecimal balance = new BigDecimal(scanner.nextLine());
		checking.setBalance(balance);
		accounts.add(checking);
		
		Account saving = new Account();
		saving.setType("saving");
		System.out.println("Please enter how much you would like to store in your saving account: ");
		BigDecimal sbalance = new BigDecimal(scanner.nextLine());
		saving.setBalance(sbalance);
		accounts.add(saving);
		
		c.setAccounts(accounts);
		
		System.out.println("Please confirm there are no errors in this information(y/n): ");
		System.out.println(
				"Username: " + c.getUsername() + "\n" + "Password: " + c.getPassword() + "First Name: " 
				+ c.getFirst() + " Last Name:  " + c.getLast() + "Your accounts: " + c.getAccounts());

		// y or n for above question
		String answer = scanner.nextLine();

		if ("y".equalsIgnoreCase(answer)) {
			ca.addCustomer(c);
			System.out.println("Registry Complete. Please wait to be confirmed by an employee.\n");
		} else {
			System.out.println("Customer information has not been stored.\n");
		}
	}

}
