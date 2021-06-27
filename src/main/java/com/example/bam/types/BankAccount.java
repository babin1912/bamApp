package com.example.bam.types;

import com.example.bam.interfaces.IMoneyTransfer;

public class BankAccount {

    private CreditCard card;

    private int balance;

    private String accountNumber;

    private Person owner;

    public BankAccount(String accountNumber, Person owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
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

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner=" + owner +
                '}';
    }

}
