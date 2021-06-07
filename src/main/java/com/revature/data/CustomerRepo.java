package com.revature.data;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerRepo {
	Customer addCustomer(Customer c);
	Customer getCustomerById(Integer id);
	Customer getCustomer(String user, String pass);
	List<Customer> getCustomers();
	Customer updateCustomer(Customer c);
	Customer removeCustomer(Customer c);
}
