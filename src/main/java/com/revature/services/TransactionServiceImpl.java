package com.revature.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import com.revature.beans.Transaction;
import com.revature.data.AccountRepo;
import com.revature.data.AccountRepoImpl;
import com.revature.data.TransactionRepo;
import com.revature.data.TransactionRepoImpl;

public class TransactionServiceImpl implements TransactionService {

	private TransactionRepo ta = new TransactionRepoImpl();
	private AccountRepo aa = new AccountRepoImpl();

	@Override
	public Transaction viewTransaction(Scanner scanner) {
		System.out.println("Please enter the id of the transaction: ");
		Integer id = Integer.valueOf(scanner.nextLine());
		return ta.getTransactionById(id);
	}

	public List<Transaction> viewCustomerTransactions(Integer i) {
		Integer id = i;
		return ta.getTransactions(id);
	}

	public void deposit(Scanner scanner, Integer id) {
		Integer chId = aa.getAccountId(id, "checking");
		Integer svId = aa.getAccountId(id, "saving");
		BigDecimal chBal = aa.getBalance(id, "checking");
		BigDecimal svBal = aa.getBalance(id, "saving");
		System.out.println("1.) Checking\n" + "2.) Saving\n");
		Integer ans = Integer.valueOf(scanner.nextLine());

		if (ans == 1) {
			System.out.println("Your current balance in checking is: " + chBal);
			System.out.println("How much would you like to deposit?");
			BigDecimal input = new BigDecimal(scanner.nextLine());
			

			// Checking to see if input is valid.
			if (input.compareTo(BigDecimal.ZERO) == 1) {
				ta.addTransaction(input, "deposit", "pending");

				// math for withdraw
				chBal = chBal.add(input);

				// editing accounts in database
				aa.updateAccount(chId, chBal);

				// return confirmation
				System.out.println("Deposit is now filed and pending");
			} else {
				System.out.println("Invalid input, input cannot be less than or equal to 0");
			}
		} else if (ans == 2) {
			System.out.println("Your current balance in saving is: " + svBal);
			System.out.println("How much would you like to deposit?");
			BigDecimal input = new BigDecimal(scanner.nextLine());

			// Checking to see if input is valid.
			if (input.compareTo(svBal) == 1) {
				ta.addTransaction(input, "deposit", "pending");

				// math for transfer
				svBal = svBal.add(input);

				// editing accounts in database
				aa.updateAccount(svId, svBal);

				// return confirmation
				System.out.println("Deposit is now filed and pending");

			} else {
				System.out.println("Invalid input, input cannot be less than or equal to 0");
			}
		} else {
			System.out.println("Invalid input please choose 1 or 2.");
		}
	}

	public void withdraw(Scanner scanner, Integer id) {
		Integer chId = aa.getAccountId(id, "checking");
		Integer svId = aa.getAccountId(id, "saving");
		BigDecimal chBal = aa.getBalance(id, "checking");
		BigDecimal svBal = aa.getBalance(id, "saving");
		System.out.println("1.) Checking\n" + "2.) Saving\n");
		Integer ans = Integer.valueOf(scanner.nextLine());

		if (ans == 1) {
			System.out.println("Your current balance in checking is: " + chBal);
			System.out.println("How much would you like to withdraw?");
			BigDecimal input = new BigDecimal(scanner.nextLine());

			// Checking to see if input is valid.
			if (input.compareTo(chBal) == -1 || input.compareTo(chBal) == 0) {
				ta.addTransaction(input, "withdraw", "pending");

				// math for withdraw
				chBal = chBal.subtract(input);

				// editing accounts in database
				aa.updateAccount(chId, chBal);

				// return confirmation
				System.out.println("Withdrawel is now filed and pending");
			} else {
				System.out.println("Invalid input, input cannot be larger than your total in checking");
			}
		} else if (ans == 2) {
			System.out.println("Your current balance in saving is: " + svBal);
			System.out.println("How much would you like to withdraw from saving?");
			BigDecimal input = new BigDecimal(scanner.nextLine());

			// Checking to see if input is valid.
			if (input.compareTo(svBal) == -1 || input.compareTo(svBal) == 0) {
				ta.addTransaction(input, "withdraw", "pending");

				// math for transfer
				svBal = svBal.subtract(input);

				// editing accounts in database
				aa.updateAccount(svId, svBal);

				// return confirmation
				System.out.println("Withdrawel is now filed and pending");

			} else {
				System.out.println("Invalid input, input cannot be larger than your total in saving");
			}
		} else {
			System.out.println("Invalid input please choose 1 or 2.");
		}
	}

	public void transfer(Scanner scanner, Integer id) {
		Integer chId = aa.getAccountId(id, "checking");
		Integer svId = aa.getAccountId(id, "saving");
		BigDecimal chBal = aa.getBalance(id, "checking");
		BigDecimal svBal = aa.getBalance(id, "saving");
		System.out.println("1.) Checking to Saving\n" + "2.) Saving to Checking\n");
		Integer ans = Integer.valueOf(scanner.nextLine());

		if (ans == 1) {
			System.out.println("Your current balance in checking is: " + chBal);
			System.out.println("Your current balance in saving is: " + svBal);
			System.out.println("How much would you like to transfer from checking to saving?");
			BigDecimal input = new BigDecimal(scanner.nextLine());

			// Checking to see if input is valid.
			if (input.compareTo(chBal) == -1 || input.compareTo(chBal) == 0) {
				ta.addTransaction(chId, svId, input, "transfer", "pending");

				// math for transfer
				chBal = chBal.subtract(input);
				svBal = svBal.add(input);

				// editing accounts in database
				aa.updateAccount(chId, chBal);
				aa.updateAccount(svId, svBal);

				// return confirmation
				System.out.println("Transaction is now filed and pending");
			} else {
				System.out.println("Invalid input, input cannot be larger than your total in checking");
			}
		} else if (ans == 2) {
			System.out.println("Your current balance in checking is: " + chBal);
			System.out.println("Your current balance in saving is: " + svBal);
			System.out.println("How much would you like to transfer from saving to checking?");
			BigDecimal input = new BigDecimal(scanner.nextLine());

			// Checking to see if input is valid.
			if (input.compareTo(svBal) == -1 || input.compareTo(svBal) == 0) {
				ta.addTransaction(svId, chId, input, "transfer", "pending");

				// math for transfer
				svBal = svBal.subtract(input);
				chBal = chBal.add(input);

				// editing accounts in database
				aa.updateAccount(chId, chBal);
				aa.updateAccount(svId, svBal);

				// return confirmation
				System.out.println("Transaction is now filed and pending");

			} else {
				System.out.println("Invalid input, input cannot be larger than your total in saving");
			}
		} else {
			System.out.println("Invalid input please choose 1 or 2.");
		}

	}

}
