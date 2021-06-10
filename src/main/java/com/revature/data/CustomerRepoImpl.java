package com.revature.data;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Customer;

import utils.JDBCConnection;

public class CustomerRepoImpl implements CustomerRepo {
//	static Logger log = Logger.getLogger(CustomerRepoImpl.class.getName());

	private AccountRepo ar = new AccountRepoImpl();
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public void addCustomer(Customer c) {
		String sql = "insert into customers values (DEFAULT, ?, ?, ?, ?, ?);";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getFirst());
			ps.setString(4, c.getLast());
			ps.setString(5, c.getStatus());

//			log.info("adding a customer");
			ps.executeUpdate();

			// grabbing new customers id and also checking to see if it was made
			Customer addedCustomer = getCustomerNoAcc(c.getUsername(), c.getPassword());
			
			for (Account acc : c.getAccounts()) {
				ar.addAccount(addedCustomer.getId(), acc.getBalance(), acc.getType());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				c.setAccounts(ar.getAccountsByCustomer(c.getId()));

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
				c.setAccounts(ar.getAccountsByCustomer(c.getId()));
				
//				log.info("grabbing customer by username and password");
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

		String sql = "select * from customers left join accounts on customers.cId = accounts.cId;";

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
				c.setAccounts(ar.getAccountsByCustomer(c.getId()));

				customers.add(c);
			}
			return customers;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer getCustomerNoAcc(String user, String pass) {
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
	public void updateCustomer(Integer id) {
		String sql = "update customers set cstatus = ? where cid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "confirmed");
			ps.setInt(2, id);

//			log.info("updating a customer");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
