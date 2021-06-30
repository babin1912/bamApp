package com.example.bam.types;

import com.example.bam.interfaces.IPayingDevice;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.services.MoneyCalculator;

public class CreditCard extends Card implements IPayingDevice {

    public CreditCard() {
    }

    public CreditCard(String id, String owner) {
        super(id, owner);
    }

    public static CreditCard getTestCard(String cardNumber, String personId) {
        return new CreditCard(cardNumber, personId);
    }

    public boolean payable(int amount, BankAccount account) {
        return MoneyCalculator.calculateAvailableMoney(account) > amount;

    }


}
