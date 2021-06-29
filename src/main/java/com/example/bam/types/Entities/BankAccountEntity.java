package com.example.bam.types.Entities;

import com.example.bam.interfaces.IPayingDevice;
import com.example.bam.types.BankAccountType;
import com.example.bam.types.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@RedisHash("BankAccountEntity")
public class BankAccountEntity implements Serializable {

    @Id
    private long id;

    private IPayingDevice payingDevice;

    private int balance;

    private String accountNumber;

    private Person owner;

    private BankAccountType bankAccountType;

    public BankAccountEntity() {
    }

    public BankAccountEntity(long id, IPayingDevice payingDevice, int balance, String accountNumber, Person owner, BankAccountType bankAccountType) {
        this.id = id;
        this.payingDevice = payingDevice;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.bankAccountType = bankAccountType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IPayingDevice getPayingDevice() {
        return payingDevice;
    }

    public void setPayingDevice(IPayingDevice payingDevice) {
        this.payingDevice = payingDevice;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }
}
