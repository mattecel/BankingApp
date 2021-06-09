package com.revature.data;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerRepo {
	void addCustomer(Customer c);
	void updateCustomer(Integer id);
	
	Customer getCustomerById(Integer id);
	Customer getCustomer(String user, String pass);
	Customer getCustomerNoAcc(String user, String pass);
	List<Customer> getCustomers();
	
	
}
