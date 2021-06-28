package com.example.bam.services;

import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

public abstract class EntitiesConvertorService {


    public static CreditCard creditCardFromEntity(CreditCardEntity creditCardEntity) {
        return new CreditCard(creditCardEntity.getCardNumber(), creditCardEntity.getOwner());
    }

    public static Person personFromEntity(PersonEntity personEntity) {
        return IEntityService.personFromEntity(personEntity);
    }

    public static PersonEntity personToEntity(Person person) {
        return IEntityService.personToEntity(person);
    }

    public static CreditCardEntity creditCardToEntity(CreditCard creditCard) {
        return new CreditCardEntity(
                creditCard.getId(),
                creditCard.getOwner()
        );
    }
}
