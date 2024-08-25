package viewmodel;

import models.BankAccount;
import models.Customer;
import exceptions.InsufficientFundsException;

public class BankingViewModel {
    private Customer customer;

    public BankingViewModel(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerDetails() {
        return "Customer: " + customer.getName() + " | Account Number: " + customer.getAccount().getAccountNumber();
    }

    public double getBalance() {
        return customer.getAccount().getBalance();
    }

    public void depositMoney(double amount) {
        customer.getAccount().deposit(amount);
    }

    public void withdrawMoney(double amount) throws InsufficientFundsException {
        customer.getAccount().withdraw(amount);
    }

    public void createNewAccount(String name, double initialBalance) {
        // Create a new account number (for simplicity, use current timestamp as account number)
        String newAccountNumber = String.valueOf(System.currentTimeMillis());
        BankAccount newAccount = new BankAccount(newAccountNumber, initialBalance);
        customer = new Customer(name, "C" + newAccountNumber, newAccount);
    }
}
