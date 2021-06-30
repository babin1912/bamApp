package com.example.bam.services.interfaces;

import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IEntityServiceTest {

    @Test
    void personFromEntity() {
        var id = "00";
        PersonEntity personEntity = new PersonEntity
                (id, "peter", "michalovics", 'M', 0);
        assertEquals(id, IEntityService.personFromEntity(personEntity).getId());
    }

    @Test
    void personToEntity() {
        var id = "00000";
        Person person = Person.getTestPerson(id);
        assertEquals(id, IEntityService.personToEntity(person).getId());
    }

    @Test
    void creditCardFromEntity() {
        var id = "00000";
        var creditCard = new CreditCardEntity(id, "00");
        assertEquals(id, IEntityService.creditCardFromEntity(creditCard).getId());

    }

    @Test
    void creditCardToEntity() {
        var id = "00000";
        var card = new CreditCard(id, "00");
        assertEquals(id, IEntityService.creditCardToEntity(card).getCardNumber());
    }
}
