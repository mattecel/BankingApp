package com.revature.data;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerRepo {
	Customer addCustomer(Customer c);
	Customer getCustomer(Integer i);
	Customer getCustomer(String user, String pass);
	List<Customer> getCustomer();
	Customer updateCustomer(Customer c);
	Customer removeCustomer(Customer c);
}
