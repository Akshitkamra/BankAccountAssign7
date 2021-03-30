package com.Akshitkamra_c0796392_a7;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    //Class member variables
    long accountNo;
    String accountHolder;
    double balance;

    //Parameterised Constructor
    public BankAccount(long accountNo, String accountHolder) {
        this.accountNo = accountNo;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }
    //Getters
    public long getAccountNo() { return accountNo; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    //Setters
    public void setAccountNo(long accountNo) { this.accountNo = accountNo; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
    public void setBalance(double balance) { this.balance = balance; }

    //Deposit
    void deposit(double money){ this.balance += money; }
    //Withdraw money
    void withdraw(double money){ this.balance -= money; }
    @Override
    public String toString(){
        //return String.format("%-20s : %d\n%-20s : %s\n%-20s : %.2f\n","Account No. ",accountNo,"Account Holder " ,accountHolder,"Balance ",this.balance);
        return String.format("Account No. \t" + accountNo +"\nAccount Holder \t" + accountHolder + "\nBalance \t\t" + this.balance);
    }

}
