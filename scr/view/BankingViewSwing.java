package view;

import viewmodel.BankingViewModel;
import exceptions.InsufficientFundsException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingViewSwing {
    private JFrame frame;
    private BankingViewModel viewModel;
    private JTextField depositField;
    private JTextField withdrawField;
    private JTextField customerNameField;
    private JTextField initialBalanceField;
    private JLabel balanceLabel;
    private JLabel accountDetailsLabel;

    public BankingViewSwing(BankingViewModel viewModel) {
        this.viewModel = viewModel;
        initialize();
    }

    private void initialize() {
        // Create the main frame
        frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);

        // Existing customer info
        accountDetailsLabel = new JLabel(viewModel.getCustomerDetails());
        accountDetailsLabel.setBounds(50, 10, 300, 30);
        frame.add(accountDetailsLabel);

        // Balance label
        balanceLabel = new JLabel("Balance: " + viewModel.getBalance());
        balanceLabel.setBounds(50, 50, 300, 30);
        frame.add(balanceLabel);

        // Deposit section
        JLabel depositLabel = new JLabel("Deposit Amount:");
        depositLabel.setBounds(50, 90, 120, 30);
        frame.add(depositLabel);

        depositField = new JTextField();
        depositField.setBounds(170, 90, 100, 30);
        frame.add(depositField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(280, 90, 100, 30);
        frame.add(depositButton);

        // Withdraw section
        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        withdrawLabel.setBounds(50, 130, 120, 30);
        frame.add(withdrawLabel);

        withdrawField = new JTextField();
        withdrawField.setBounds(170, 130, 100, 30);
        frame.add(withdrawField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(280, 130, 100, 30);
        frame.add(withdrawButton);

        // New account creation section
        JLabel createAccountLabel = new JLabel("Create New Account");
        createAccountLabel.setBounds(50, 180, 150, 30);
        frame.add(createAccountLabel);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(50, 220, 120, 30);
        frame.add(nameLabel);

        customerNameField = new JTextField();
        customerNameField.setBounds(170, 220, 100, 30);
        frame.add(customerNameField);

        JLabel initialBalanceLabel = new JLabel("Initial Balance:");
        initialBalanceLabel.setBounds(50, 260, 120, 30);
        frame.add(initialBalanceLabel);

        initialBalanceField = new JTextField();
        initialBalanceField.setBounds(170, 260, 100, 30);
        frame.add(initialBalanceField);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(280, 260, 150, 30);
        frame.add(createAccountButton);

        // Event listeners
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositMoney();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawMoney();
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAccount();
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    // Deposit money logic
    private void depositMoney() {
        double amount = Double.parseDouble(depositField.getText());
        viewModel.depositMoney(amount);
        updateBalance();
        JOptionPane.showMessageDialog(frame, "Deposit successful!");
    }

    // Withdraw money logic
    private void withdrawMoney() {
        double amount = Double.parseDouble(withdrawField.getText());
        try {
            viewModel.withdrawMoney(amount);
            updateBalance();
            JOptionPane.showMessageDialog(frame, "Withdrawal successful!");
        } catch (InsufficientFundsException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Create new account logic
    private void createNewAccount() {
        String customerName = customerNameField.getText();
        double initialBalance = Double.parseDouble(initialBalanceField.getText());

        viewModel.createNewAccount(customerName, initialBalance);
        updateAccountDetails();
        updateBalance();
        JOptionPane.showMessageDialog(frame, "New account created successfully!");
    }

    // Update the balance label
    private void updateBalance() {
        balanceLabel.setText("Balance: " + viewModel.getBalance());
    }

    // Update the customer details label
    private void updateAccountDetails() {
        accountDetailsLabel.setText(viewModel.getCustomerDetails());
    }
}
