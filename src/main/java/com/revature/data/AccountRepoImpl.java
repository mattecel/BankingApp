package com.revature.data;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

import com.revature.beans.Account;

import utils.JDBCConnection;

public class AccountRepoImpl implements AccountRepo {
//	static Logger log = Logger.getLogger(AccountRepoImpl.class.getName());

	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Account getAccountById(Integer id) {
		String sql = "select * from accounts where aid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Account a = new Account();
				a.setId(rs.getInt("aid"));
				a.setType(rs.getString("atype"));
				a.setBalance(rs.getBigDecimal("abalance"));
				
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateAccount(Integer id, BigDecimal balance) {
		String sql = "update accounts set abalance = ? where aid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, balance);
			ps.setInt(2, id);

//			log.info("updating account info");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Account> getAccountsByCustomer(Integer id) {

		List<Account> accounts = new ArrayList<Account>();
		String sql = "select * from accounts where cid = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account a = new Account();
				a.setId(rs.getInt("aid"));
				a.setType(rs.getString("atype"));
				a.setBalance(rs.getBigDecimal("abalance"));

				accounts.add(a);
			}
			return accounts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addAccount(Integer id, BigDecimal balance, String type) {
		String sql = "insert into accounts values (DEFAULT, ?, ?, ?);";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, balance);
			ps.setString(2, type);
			ps.setInt(3, id);

//			log.info("adding account");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public BigDecimal getBalance(Integer id, String type) {
		String sql = "select * from accounts where cid = ? and atype = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, type);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				BigDecimal bd = rs.getBigDecimal("abalance");
				return bd;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer getAccountId(Integer id, String type) {
		String sql = "select * from accounts where cid = ? and atype = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, type);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Integer aid = rs.getInt("aid");
				return aid;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
