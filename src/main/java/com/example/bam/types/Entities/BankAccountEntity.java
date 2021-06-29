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
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("BankAccountEntity")
public class BankAccountEntity implements Serializable {

    @Id
    private long id;

    private IPayingDevice payingDevice;

    private int balance;

    private String accountNumber;

    private Person owner;

    private BankAccountType bankAccountType;
}
