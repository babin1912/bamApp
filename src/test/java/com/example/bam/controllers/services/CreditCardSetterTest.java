package com.example.bam.controllers.services;

import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

class CreditCardSetterTest {

    @Mock
    private CreditCardRepository creditCardRepository = Mockito.mock(CreditCardRepository.class);

    private CreditCardSetter creditCardSetter = Mockito.mock(CreditCardSetter.class);

    @Test
    void testSaveNewCard() {
        CreditCard originalCard = new CreditCard();
        originalCard.setId("magda");
        originalCard.setId("numb");
    }
}
