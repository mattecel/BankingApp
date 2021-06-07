package com.revature.data;

import com.revature.beans.Account;

public interface AccountRepo {
	Account getAccountById(Integer id);
	Account updateAccount(Integer id, Double balance);
}
