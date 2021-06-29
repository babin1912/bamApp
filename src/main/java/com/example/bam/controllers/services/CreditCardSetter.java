package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.ICreditCardSetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardSetter implements ICreditCardSetter {

    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardSetter(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCardEntity saveNewCard(CreditCard creditCard) {
        return creditCardRepository.save(IEntityService.creditCardToEntity(creditCard));
    }
}
