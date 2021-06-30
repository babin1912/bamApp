package com.example.bam.services;

import com.example.bam.types.BankAccount;
import com.example.bam.types.BankAccountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorTest {

    @Test
    void calculateAvailableMoneyEnough() {
        int amountOfMoney = 5;
        var bankAccount = getTestAccount(amountOfMoney);
        bankAccount.setBankAccountType(BankAccountType.NORMAL);
        assertTrue(MoneyCalculator.calculateAvailableMoney(bankAccount) >= amountOfMoney);
    }

    private BankAccount getTestAccount(int amountOfMoney) {
        var bankAccount = new BankAccount();
        bankAccount.setBalance(amountOfMoney);
        return bankAccount;
    }

    @Test
    void calculateAvailableMoneyNotEnough() {
        int amountOfMoney = 5;
        var bankAccount = getTestAccount(amountOfMoney);
        bankAccount.setBankAccountType(BankAccountType.NORMAL);
        assertTrue(MoneyCalculator.calculateAvailableMoney(bankAccount) > (amountOfMoney-1));
    }

}
