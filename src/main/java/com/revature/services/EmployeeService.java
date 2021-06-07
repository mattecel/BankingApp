package com.revature.services;

import java.util.Scanner;

import com.revature.beans.Employee;

public interface EmployeeService {
	Employee login(Scanner scanner);
	Employee operate(Scanner scanner);
	void viewAllTransactions();
	void viewCustomerAccouint();
}
