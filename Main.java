import java.util.Locale;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
System.out.print("Enter account holder name: ");
String name = scanner.nextLine();

    BankAccount account = new BankAccount(name, 0.0);
    boolean running = true;

    while (running) {
        System.out.println("\n=== Simple Bank Account (v1.1) ===");
        System.out.println("1. Deposit");
        System.out.println("2. Check Balance");
        System.out.println("3. Withdraw");
        System.out.println("4. View Transaction History");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
                break;
            case 2:
                System.out.printf(Locale.US, "Account: %s | Current Balance: %.2f SAR%n",
                        account.getAccountHolder(), account.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 4:
                account.printTransactionHistory();
                break;
            case 0:
                running = false;
                System.out.println("Thank you for using Simple Bank Account.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    scanner.close();
}
}