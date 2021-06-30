package com.example.bam.controllers.services;

import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.types.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-test.properties")
class PersonSetterTest {


    private PersonRepository personRepository;

    private CreditCardSetter creditCardSetter;

    private PersonSetter personSetter;

    private static String person_id = "01";

    @Autowired
    public PersonSetterTest(CreditCardRepository creditCardRepository, PersonRepository personRepository)  {
        this.personRepository = personRepository;
        this.creditCardSetter = new CreditCardSetter(creditCardRepository);
        personSetter = new PersonSetter(personRepository, creditCardRepository, creditCardSetter);

    }

    @Test
    void saveNewPerson() throws Exception {
        personSetter.saveNew(Person.getTestPerson(person_id));
        assertTrue(personRepository.getPersonById(person_id).isPresent());

    }

}
