package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.data.EmployeeRepo;
import com.revature.data.EmployeeRepoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepo ea = new EmployeeRepoImpl();

	@Override
	public Employee login(Scanner scanner) {
		System.out.println("Please enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		return ea.getEmployee(username, password);
	}

	@Override
	public Employee operate(Scanner scanner) {
		
		return null;
	}

	@Override
	public void viewAllTransactions() {

		
	}

	@Override
	public void viewCustomerAccouint() {

		
	}

}
