package com.Akshitkamra_c0796392_a7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAccount {
    static ArrayList<BankAccount> accounts = new ArrayList();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        while (option != 5) {
            System.out.println("1. Create a user account.");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdrawal");
            System.out.println("4. Check User Balance");
            System.out.println("5. Quit");
            System.out.print("Choose from the menu : ");
            option = s.nextInt();
            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositAmount();
                    break;
                case 3 : withdrawalAmount();
                    break;
                case 4 : checkBalance();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Please select a valid option: ");
                    break;
            }
        }
    }

    public static void createAccount() {
        long accountNo;
        String name;
        boolean exists = false;
        System.out.print("Please enter the account number : ");
        accountNo = s.nextLong();
        while (String.valueOf(accountNo).length() != 6 || accountNo < 0) {
            System.out.println("Enter valid account number.");
            System.out.print("Enter account number : ");
            accountNo = s.nextLong();
        }
        System.out.print("Enter account holder's name : ");
        s.nextLine();
        name = s.nextLine();
        if (accounts.size() > 0) {
            for (BankAccount a : accounts) {
                if (a.accountNo == accountNo) {
                    exists = true;
                    System.out.println("An account has already been established.");
                }
            }
            if (!exists) {
                accounts.add(new BankAccount(accountNo, name));
                System.out.println("The account has been established.");
            }
        } else {
            accounts.add(new BankAccount(accountNo, name));
            System.out.println("The account has been established.");
        }
    }

    public static void depositAmount() {
        double amount;
        long accountNo;
        boolean exists = false;
        if (accounts.size() > 0) {
            System.out.print("Enter your account number : ");
            accountNo = s.nextLong();
            for (BankAccount a : accounts) {
                if (a.accountNo == accountNo) {
                    exists = true;
                    System.out.print("Enter total amount you want to deposit : ");
                    amount = s.nextDouble();
                    while (amount <= 0) {
                        System.out.println("Please enter a value that is greater than zero.");
                        System.out.print("Enter total amount to get deposit : ");
                        amount = s.nextDouble();
                    }
                    a.deposit(amount);
                    //System.out.println(a.toString());
                    System.out.println("Amount successfully deposited ");
                }
            }
        }
    }

    private static void withdrawalAmount() {
        double amount;
        System.out.print("Enter your account number : ");
        long accountNo = s.nextLong();
        for (BankAccount a : accounts) {
            if (a.accountNo == accountNo) {
                System.out.println(a.toString());
                System.out.print("Enter total amount you want to withdraw : ");
                amount = s.nextDouble();
                a.withdraw(amount);
                System.out.println(a.toString());
            }
        }
    }

    private static void checkBalance() {
        System.out.print("Enter your account number : ");
        long accountNo = s.nextLong();
        for (BankAccount a : accounts) {
            if (a.accountNo == accountNo) {
                System.out.println(a.toString());
            }
        }
    }

}
