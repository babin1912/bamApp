package com.example.bam.interfaces;

import com.example.bam.types.BankAccount;

public interface IPayingDevice {


     boolean pay(int amount, BankAccount account);
}
