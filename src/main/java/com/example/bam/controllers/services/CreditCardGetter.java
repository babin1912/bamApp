package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.ICreditCardGetter;
import com.example.bam.types.CreditCard;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CreditCardGetter implements ICreditCardGetter {

    @Override
    public Optional<CreditCard> getCreditCardById(String id) {
        return Optional.empty();
    }

    @Override
    public Set<CreditCard> getCardsByPerson() {
        return null;
    }
}
