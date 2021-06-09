package repotests;

import java.math.BigDecimal;

import org.junit.*;

import com.revature.beans.Account;

import com.revature.data.AccountRepo;
import com.revature.data.AccountRepoImpl;

public class RepoTest {

	private AccountRepo ar = new AccountRepoImpl();

	@Test
	public void addTest() {
		BigDecimal bd = new BigDecimal("4000.00");
		Integer id = 1;
		Account expected = new Account(id, bd, "checking");
		Account check = ar.getAccountById(id);
		Assert.assertEquals(expected, check);
	}
}
