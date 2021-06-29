package com.example.bam.controllers.interfaces;

import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;

public interface ICreditCardSetter {
    CreditCardEntity saveNewCard(CreditCard creditCard);

}
