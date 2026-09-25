import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Bank Account Management System (Console-based)
 * Features: Create Account, Deposit, Withdraw, Check Balance, View All Accounts
 */

class Account {
    int accountNumber;
    String accountHolder;
    double balance;

    Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs. " + amount + " successfully. New Balance: Rs. " + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrew Rs. " + amount + " successfully. New Balance: Rs. " + balance);
        }
    }

    void display() {
        System.out.println("Account No: " + accountNumber +
                " | Holder: " + accountHolder +
                " | Balance: Rs. " + balance);
    }
}

class Bank {
    List<Account> accounts = new ArrayList<>();
    int nextAccountNumber = 1001;

    Account createAccount(String holderName, double initialDeposit) {
        Account acc = new Account(nextAccountNumber, holderName, initialDeposit);
        accounts.add(acc);
        System.out.println("Account created successfully! Account Number: " + nextAccountNumber);
        nextAccountNumber++;
        return acc;
    }

    Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    void showAllAccounts() {
        System.out.println("\n---- All Accounts ----");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account acc : accounts) {
                acc.display();
            }
        }
    }
}

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n===== Bank Account Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initial = sc.nextDouble();
                    bank.createAccount(name, initial);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAccNo = sc.nextInt();
                    Account depAcc = bank.findAccount(depAccNo);
                    if (depAcc == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.print("Enter Amount to Deposit: ");
                        double depAmount = sc.nextDouble();
                        depAcc.deposit(depAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int witAccNo = sc.nextInt();
                    Account witAcc = bank.findAccount(witAccNo);
                    if (witAcc == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.print("Enter Amount to Withdraw: ");
                        double witAmount = sc.nextDouble();
                        witAcc.withdraw(witAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int balAccNo = sc.nextInt();
                    Account balAcc = bank.findAccount(balAccNo);
                    if (balAcc == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("Current Balance: Rs. " + balAcc.balance);
                    }
                    break;

                case 5:
                    bank.showAllAccounts();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}