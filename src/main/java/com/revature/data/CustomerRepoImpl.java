package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;

import utils.JDBCConnection;

public class CustomerRepoImpl implements CustomerRepo {

	private Connection conn = JDBCConnection.getConnection();
	
	@Override
	public Customer addCustomer(Customer c) {
		
		return null;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		String sql = "select * from customers where cid = ?;";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("cid"));
				c.setUsername(rs.getString("cusername"));
				c.setPassword(rs.getString("cpassword"));
				c.setFirst(rs.getString("cfirstname"));
				c.setLast(rs.getString("clastname"));
				c.setStatus(rs.getString("cstatus"));
				
				return c;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomer(String user, String pass) {
		String sql = "select * from customers where cusername = ? and cpassword = ?;";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("cid"));
				c.setUsername(rs.getString("cusername"));
				c.setPassword(rs.getString("cpassword"));
				c.setFirst(rs.getString("cfirstname"));
				c.setLast(rs.getString("clastname"));
				c.setStatus(rs.getString("cstatus"));
				
				return c;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		String sql = "select * from customers;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("cid"));
				c.setUsername(rs.getString("cusername"));
				c.setPassword(rs.getString("cpassword"));
				c.setFirst(rs.getString("cfirstname"));
				c.setLast(rs.getString("clastname"));
				c.setStatus(rs.getString("cstatus"));
				
				
				
				customers.add(c);
			}
			return customers;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		
		return null;
	}

	@Override
	public Customer removeCustomer(Customer c) {
		
		return null;
	}

}
