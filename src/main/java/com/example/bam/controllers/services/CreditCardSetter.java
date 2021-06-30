package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.ITypeSetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for setting credit cards
 */
@Service
public class CreditCardSetter implements ITypeSetter<CreditCard> {

    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardSetter(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }


    /**
     * Saves new credit card in repository
     * @param creditCard
     * @return saved credit card
     */
    public CreditCard saveNew(CreditCard creditCard) {
        if (creditCardRepository.findById(creditCard.getId()).isPresent()) throw new NullPointerException();
        return IEntityService.creditCardFromEntity(
                creditCardRepository.save(
                        IEntityService.creditCardToEntity(creditCard)
                )
        );
    }
}
