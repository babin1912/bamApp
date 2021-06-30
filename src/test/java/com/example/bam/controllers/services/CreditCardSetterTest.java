package com.example.bam.controllers.services;

import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.EntitiesConvertorService;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import com.example.bam.types.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-test.properties")
class CreditCardSetterTest {

    private CreditCardRepository creditCardRepository;

    private PersonRepository personRepository;

    private CreditCardSetter creditCardSetter;

    private static String person_id = "00";

    @Autowired
    public CreditCardSetterTest(CreditCardRepository creditCardRepository, PersonRepository personRepository) {
        this.creditCardRepository = creditCardRepository;
        this.personRepository = personRepository;
        this.creditCardSetter = new CreditCardSetter(creditCardRepository);
    }

    @Test
    void testSaveNewCard() {
        String id = "testik";
        var people = personRepository.getAll();
        creditCardSetter.saveNewCard(CreditCard.getTestCard(id, person_id));
        var j = creditCardRepository.findById(id);
        assertTrue(j.isPresent() && j.get().getCardNumber().equals(id));
    }

    @BeforeEach
    void preparePerson(){
        var m = IEntityService.personToEntity(Person.getTestPerson(person_id));
        personRepository.save(m);
    }
    @AfterEach
    void removePerson(){
        personRepository.delete(personRepository.getPersonById(person_id).get());
    }
}
