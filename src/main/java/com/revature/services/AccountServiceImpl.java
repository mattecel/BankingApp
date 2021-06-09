package com.revature.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.data.AccountRepo;
import com.revature.data.AccountRepoImpl;

public class AccountServiceImpl implements AccountService {
	private AccountRepo aa = new AccountRepoImpl();
	
	@Override
	public void createAcc(Scanner scanner, Customer customer) {
		
	}

	// To see all accounts with the customer
	@Override
	public List<Account> observeAccs(Integer id) {
		return aa.getAccountsByCustomer(id);
	}

	@Override
	public BigDecimal viewBalance(Integer id, String type) {
		return aa.getBalance(id, type);
	}

}
