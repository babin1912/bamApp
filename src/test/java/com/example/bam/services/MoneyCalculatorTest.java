package com.example.bam.services;

import com.example.bam.types.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorTest {

    @Test
    void calculateAvailableMoneyEnough() {
        BankAccount bankAccount = new BankAccount();
        int amountOfMoney = 5;
        bankAccount.setBalance(amountOfMoney);
        assertTrue(MoneyCalculator.calculateAvailableMoney(bankAccount) <= amountOfMoney);
    }
    @Test
    void calculateAvailableMoneyNotEnough() {
        BankAccount bankAccount = new BankAccount();
        int amountOfMoney = 5;
        bankAccount.setBalance(amountOfMoney);
        assertTrue(MoneyCalculator.calculateAvailableMoney(bankAccount) > (amountOfMoney-1));
    }

    @Test
    void isTransactional() {
    }
}
