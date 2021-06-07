package com.revature.data;

import java.util.List;

import com.revature.beans.Transaction;

public interface TransactionRepo {	
	Transaction getTransactionById(Integer id);
	List<Transaction> getTransactions(Integer id);
	List<Transaction> getAllTransactions();
}
