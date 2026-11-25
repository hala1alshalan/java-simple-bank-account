import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BankAccount {
private String accountHolder;
private double balance;
private List<String> transactionHistory;

public BankAccount(String accountHolder, double initialBalance) {
    this.accountHolder = accountHolder;
    this.balance = Math.max(0, initialBalance);
    this.transactionHistory = new ArrayList<>();
    this.transactionHistory.add(String.format(Locale.US, "Account opened with balance: %.2f SAR", this.balance));
}

public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        String record = String.format(Locale.US, "Deposit: +%.2f SAR | Balance: %.2f SAR", amount, balance);
        transactionHistory.add(record);
        System.out.printf(Locale.US, "Deposited: %.2f SAR | New Balance: %.2f SAR%n", amount, balance);
    } else {
        System.out.println("Error: Deposit amount must be positive.");
    }
}

public void withdraw(double amount) {
    if (amount <= 0) {
        System.out.println("Error: Withdrawal amount must be positive.");
    } else if (amount > balance) {
        System.out.printf(Locale.US, "Error: Insufficient funds. Current Balance: %.2f SAR%n", balance);
    } else {
        balance -= amount;
        String record = String.format(Locale.US, "Withdraw: -%.2f SAR | Balance: %.2f SAR", amount, balance);
        transactionHistory.add(record);
        System.out.printf(Locale.US, "Withdrew: %.2f SAR | New Balance: %.2f SAR%n", amount, balance);
    }
}

public void printTransactionHistory() {
    System.out.println("\n--- Transaction History ---");
    for (String record : transactionHistory) {
        System.out.println("- " + record);
    }
}

public double getBalance() {
    return balance;
}

public String getAccountHolder() {
    return accountHolder;
}
}