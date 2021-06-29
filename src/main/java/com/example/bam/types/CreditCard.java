package com.example.bam.types;

import com.example.bam.interfaces.IPayingDevice;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.services.MoneyCalculator;

public class CreditCard extends Card implements IPayingDevice {

    public CreditCard() {
    }

    public CreditCard(String id, long owner) {
        super(id, owner);
    }

    public boolean payable(int amount, BankAccount account) {
        return MoneyCalculator.calculateAvailableMoney(account) > amount;

    }


}
