package com.example.bam.interfaces;

import com.example.bam.types.BankAccount;

public interface IPayingDevice {


     boolean payable(int amount, BankAccount account);
}
