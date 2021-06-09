package com.revature.data;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.apache.log4j.Logger;

import com.revature.beans.Employee;

import utils.JDBCConnection;

public class EmployeeRepoImpl implements EmployeeRepo {
//	static Logger log = Logger.getLogger(EmployeeRepoImpl.class.getName());

	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployee(String user, String pass) {
		String sql = "select * from employees where eusername = ? and epassword = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("eid"));
				e.setUsername(rs.getString("eusername"));
				e.setPassword(rs.getString("epassword"));
				e.setFirst(rs.getString("efirstname"));
				e.setLast(rs.getString("elastname"));
				
//				log.info("Grabbing employee by id");
				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
