package models;

public class Customer {
    private String name;
    private String customerId;
    private BankAccount account;

    public Customer(String name, String customerId, BankAccount account) {
        this.name = name;
        this.customerId = customerId;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BankAccount getAccount() {
        return account;
    }
}
