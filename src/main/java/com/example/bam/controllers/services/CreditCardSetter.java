package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.ICreditCardSetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.services.EntitiesConvertorService;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardSetter implements ICreditCardSetter {

    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardSetter(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public void saveNewCard(CreditCard creditCard) {
        creditCardRepository.save(IEntityService.creditCardToEntity(creditCard));
    }
}
