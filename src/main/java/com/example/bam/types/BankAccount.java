package com.example.bam.types;

import com.example.bam.interfaces.IMoneyTransfer;
import com.example.bam.interfaces.IPayingDevice;
import com.example.bam.services.MoneyCalculator;


public class BankAccount {

    private IPayingDevice payingDevice;

    private int balance;

    private String accountNumber;

    private Person owner;

    private BankAccountType bankAccountType;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, Person owner, IPayingDevice payingDevice, BankAccountType bankAccountType) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.payingDevice = payingDevice;
        this.bankAccountType = bankAccountType;
        this.balance = IMoneyTransfer.startingValue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner=" + owner +
                '}';
    }


    /* generated */
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public IPayingDevice getPayingDevice() {
        return payingDevice;
    }

    public void setPayingDevice(IPayingDevice payingDevice) {
        this.payingDevice = payingDevice;
    }
}
