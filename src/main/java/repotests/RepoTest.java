package repotests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.revature.beans.Customer;
import com.revature.data.CustomerRepoImpl;

import utils.JDBCConnection;

public class RepoTest {
	
	private CustomerRepoImpl cr = new CustomerRepoImpl();

	@Test
	public void getCustomerById() {
		System.out.println(cr.getCustomerById(1)) ;
	}
}
