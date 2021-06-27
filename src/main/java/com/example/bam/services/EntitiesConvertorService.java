package com.example.bam.services;

import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;

public class EntitiesConvertorService {

    public static CreditCard creditCardFromEntity(CreditCardEntity creditCardEntity) {
        return new CreditCard(creditCardEntity.getCardNumber(), creditCardEntity.getOwner());
    }

    public static Person personFromEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getGender(),
                personEntity.getAccountBalance());
    }
}
