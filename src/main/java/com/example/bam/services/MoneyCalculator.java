package com.example.bam.services;

import com.example.bam.types.BankAccount;

public class MoneyCalculator {

    public static int calculateAvailableMoney(BankAccount account) {
        return account.getBalance();
    }
}
