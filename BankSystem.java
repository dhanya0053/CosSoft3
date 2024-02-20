package practice1;

import java.util.Scanner;

//Step 1: Create a class to represent the ATM machine.
class ATM {

	private BankAccount account;

	public ATM(BankAccount account) {
		this.account = account;
	}

	// Implement methods for each option
	public void withdraw(double amount) {
		if (account.getBalance() >= amount) {
			account.withdraw(amount);
			System.out.println("Successfully withdrew " + amount);
		} else {
			System.out.println("Insufficient balance for withdrawal");
		}
	}

	public void deposit(double amount) {
		account.deposit(amount);
		System.out.println("Successfully deposited " + amount);
	}

	public void checkBalance() {
		System.out.println("Your current balance is " + account.getBalance());
	}
}

//Step 2: Create a class to represent the user's bank account.
class BankAccount {

	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}

	public void deposit(double amount) {
		balance += amount;
	}
}

//Step 3: Use the ATM and BankAccount classes to implement the ATM user interface.
public class Main {

	public static void main(String[] args) {
		BankAccount account = new BankAccount(500);
		ATM atm = new ATM(account);

		// User Interface
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("\nWelcome to the ATM");
			System.out.println("1. Check Balance");
			System.out.println("2. Withdraw Cash");
			System.out.println("3. Deposit Cash");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				atm.checkBalance();
				break;
			case 2:
				System.out.println("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				atm.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Enter amount to deposit: ");
				double depositAmount = scanner.nextDouble();
				atm.deposit(depositAmount);
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		scanner.close();
	}
}