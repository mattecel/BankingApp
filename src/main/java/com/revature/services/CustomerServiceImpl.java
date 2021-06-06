package com.revature.services;

import java.util.Scanner;

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

		System.out.println("Please confirm there are no errors in this information(y/n): ");
		System.out.println(
				"Username: " + c.getUsername() + "\n" + "First Name: " + c.getFirst() + " Last Name:  " + c.getLast());

		// y or n for above question
		String answer = scanner.nextLine();

		if ("y".equalsIgnoreCase(answer)) {
			ca.addCustomer(c);
			// checking to see if customer was made
			if (c.getId() != 0) {
				System.out.println("Customer information is registered. Please wait to be confirmed.");
			} else {
				System.out.println("Registry has failed. Please try again later.");
			}
		} else {
			System.out.println("Customer information has not been stored.");
		}
	}

}
