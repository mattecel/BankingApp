package com.revature.data;

import java.math.BigDecimal;
import java.util.List;

import com.revature.beans.Transaction;

public interface TransactionRepo {	
	
	void addTransaction(Integer from, Integer to, BigDecimal amount, String type, String status);
	void addTransaction(BigDecimal amount, String type, String status);
	void updateTransaction(Integer id);
	Transaction getTransactionById(Integer id);
	List<Transaction> getTransactions(Integer id);
	List<Transaction> getAllTransactions();
	
}
