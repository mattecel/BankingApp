package com.revature.services;

import java.util.List;
import java.util.Scanner;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Transaction;
import com.revature.data.CustomerRepo;
import com.revature.data.CustomerRepoImpl;
import com.revature.data.EmployeeRepo;
import com.revature.data.EmployeeRepoImpl;
import com.revature.data.TransactionRepo;
import com.revature.data.TransactionRepoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepo ea = new EmployeeRepoImpl();
	private CustomerRepo ca = new CustomerRepoImpl();
	private TransactionRepo ta = new TransactionRepoImpl();

	@Override
	public Employee login(Scanner scanner) {
		System.out.println("Please enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();
		return ea.getEmployee(username, password);
	}

	@Override
	public Customer viewCustomerAccount(Scanner scanner) {
		System.out.println("Please enter the id of the customer: ");
		Integer id = Integer.valueOf(scanner.nextLine());
		return ca.getCustomerById(id);
	}

	@Override
	public List<Transaction> viewAllTransactions() {
		return ta.getAllTransactions();
	}

	@Override
	public Transaction verifyTransaction(Integer id) {
		ta.updateTransaction(id);
		return (ta.getTransactionById(id));
	}

	@Override
	public Customer verifyCustomer(Integer id) {
		ca.updateCustomer(id);
		return ca.getCustomerById(id);
	}

	@Override
	public List<Customer> getCustomers() {
		return ca.getCustomers();
	}

}
