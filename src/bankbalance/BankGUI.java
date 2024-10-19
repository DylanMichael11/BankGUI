package bankbalance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI {

    // Main BankAccount class 
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient funds.");
            }
        }
    }

    public static void main(String[] args) {
        //  simple BankAccount 
        BankAccount account = new BankAccount(0.0);

        // Create JFrame window
        JFrame frame = new JFrame("Bank Balance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create JPanel
        JPanel panel = new JPanel();

        // Create JLabel for displaying balance
        JLabel balanceLabel = new JLabel("Balance: $0.00");

        // Create JTextField for entering amount
        JTextField amountField = new JTextField(10);

        //buttons for deposit, withdraw, and exit
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        // Add ActionListeners
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
                    amountField.setText("");  // Clear the input field
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.withdraw(amount);
                    balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
                    amountField.setText("");  // Clear the input field
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Final balance: $" + String.format("%.2f", account.getBalance()));
                System.exit(0);
            }
        });

        // Add components to the panel
        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
