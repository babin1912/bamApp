package com.example.bam.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void pay() {
        CreditCard card = new CreditCard("645", 0L);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(500);
        assertTrue(card.payable(30, bankAccount));
    }

    @Test
    void payNot() {
        CreditCard card = new CreditCard("645", 0L);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(29);
        assertFalse(card.payable(30, bankAccount));
    }
}
