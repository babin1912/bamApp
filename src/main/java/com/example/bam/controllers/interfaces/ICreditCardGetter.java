package com.example.bam.controllers.interfaces;

import com.example.bam.types.CreditCard;

import java.util.Optional;
import java.util.Set;

public interface ICreditCardGetter {
    Optional<CreditCard> getCreditCardById(String id);
    Set<CreditCard> getCardsByPerson();
}
