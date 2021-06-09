package com.revature.data;

import java.math.BigDecimal;
import java.util.List;

import com.revature.beans.Account;

public interface AccountRepo {
	
	Account getAccountById(Integer id);
	List<Account> getAccountsByCustomer(Integer id);
	void updateAccount(Integer id, BigDecimal balance);
	void addAccount(Integer id, BigDecimal balance, String type);
	BigDecimal getBalance(Integer id, String type);
	Integer getAccountId(Integer id, String type);
}
