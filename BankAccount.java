import java.util.Locale;

public class BankAccount {
private String accountHolder;
private double balance;

public BankAccount(String accountHolder, double initialBalance) {
    this.accountHolder = accountHolder;
    this.balance = Math.max(0, initialBalance);
}

public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
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
        System.out.printf(Locale.US, "Withdrew: %.2f SAR | New Balance: %.2f SAR%n", amount, balance);
    }
}

public double getBalance() {
    return balance;
}

public String getAccountHolder() {
    return accountHolder;
}
}