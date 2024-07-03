import java.util.Scanner;

public class SimpleBankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();
        while (true) {
            System.out.println("Simple Banking Application");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.printf("Current balance: %.2f\n", account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using Simple Banking Application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
class BankAccount {
    private double balance;
    public BankAccount() {
        this.balance = 0.0;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("%.2f deposited. New balance: %.2f\n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("%.2f withdrawn. New balance: %.2f\n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please enter a smaller amount.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive number.");
        }
    }
    public double getBalance() {
        return balance;
    }
}
