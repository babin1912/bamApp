package com.example.bam.services.interfaces;

import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;

public interface IEntityService {
   static Person personFromEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getGender(),
                personEntity.getAccountBalance());
    }

    static PersonEntity personToEntity(Person person) {
        return new PersonEntity(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getGender(),
                person.getAccountBalance()
        );
    }

    static CreditCard creditCardFromEntity(CreditCardEntity creditCardEntity) {
        return new CreditCard(creditCardEntity.getCardNumber(), creditCardEntity.getOwner());
    }
    public static CreditCardEntity creditCardToEntity(CreditCard creditCard) {
        return new CreditCardEntity(
                creditCard.getId(),
                creditCard.getOwner()
        );
    }

}
