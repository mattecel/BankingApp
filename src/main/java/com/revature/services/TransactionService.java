package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Transaction;

public interface TransactionService {
	
	// Just viewing
	Transaction viewTransaction (Scanner scanner);
	List<Transaction> viewCustomerTransactions (Integer i);
	
	// Actual change in accounts
	void deposit(Scanner scanner, Integer id);
	void withdraw(Scanner scanner, Integer id);
	void transfer(Scanner scanner, Integer id);
	
}
