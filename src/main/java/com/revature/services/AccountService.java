package com.revature.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface AccountService {
	
	void createAcc(Scanner scanner, Customer customer);
	
	BigDecimal viewBalance(Integer id, String type);
	List<Account> observeAccs(Integer id);
	
}
