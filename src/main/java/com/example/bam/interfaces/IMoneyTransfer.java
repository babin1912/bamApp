package com.example.bam.interfaces;

import com.example.bam.types.BankAccount;

/**
 * Interface for money transferring classes
 */
public interface IMoneyTransfer {

    int startingValue = 0; // they can have parameter ;) i knew they cannot have constructor (in java) but not params ;)

    boolean receiveMoney(int amount, BankAccount account);

    boolean sendMoney(int amount, BankAccount account);
}
