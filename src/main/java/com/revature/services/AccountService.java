package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Customer;

public interface AccountService {
	
	void createAcc(Scanner scanner, Customer customer);
	
	void observeAcc(Scanner scanner, Customer customer);
}
