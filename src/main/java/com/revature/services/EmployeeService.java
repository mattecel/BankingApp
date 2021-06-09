package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Transaction;

public interface EmployeeService {
	Employee login(Scanner scanner);
	
	Transaction verifyTransaction(Integer id);
	List<Transaction> viewAllTransactions();
	
	List<Customer> getCustomers();
	Customer viewCustomerAccount(Scanner scanner);
	Customer verifyCustomer(Integer id);
}
