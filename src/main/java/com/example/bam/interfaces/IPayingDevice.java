package com.example.bam.interfaces;

import com.example.bam.types.BankAccount;

/**
 * For devices that can by used to pay
 */
public interface IPayingDevice {


     boolean payable(int amount, BankAccount account);
}
