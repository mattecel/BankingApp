package com.revature.data;

import com.revature.beans.Employee;

public interface EmployeeRepo {
	Employee getEmployee(String user, String pass);
}
