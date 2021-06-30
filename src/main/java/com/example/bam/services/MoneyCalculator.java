package com.example.bam.services;

import com.example.bam.types.BankAccount;

/**
 * Service for basic money calculations
 */
public abstract class MoneyCalculator {

    /**
     * Calculates amount of available money in account
     * @param account
     * @return
     */
    public static double calculateAvailableMoney(BankAccount account) {
        return account.getBalance() + account.getBankAccountType().getTransferFee();
    }


    /**
     * Checking if payment is transactional
     * @param amount
     * @param account
     * @return if payment is possible
     */
    public static boolean isTransactional(int amount, BankAccount account) {
        return MoneyCalculator.calculateAvailableMoney(account) > amount;
    }
}
