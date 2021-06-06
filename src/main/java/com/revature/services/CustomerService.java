package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Customer;

public interface CustomerService {
	Customer login(Scanner scanner);
	void register(Scanner scanner);
}
