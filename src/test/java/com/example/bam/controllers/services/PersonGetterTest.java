package com.example.bam.controllers.services;

import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-test.properties")
class PersonGetterTest {

    private CreditCardRepository creditCardRepository;

    private PersonRepository personRepository;

    private PersonGetter personGetter;

    private static String person_id = "01";

    @Autowired
    public PersonGetterTest(CreditCardRepository creditCardRepository, PersonRepository personRepository) {
        this.creditCardRepository = creditCardRepository;
        this.personRepository = personRepository;
        this.personGetter = new PersonGetter(personRepository, creditCardRepository);
    }

    @Test
    void getAllPeople() {
        var all = personGetter.getAll();
        assertTrue(personGetter.getAll().size() > 0);
    }

    @Test
    void getById() {
        assertNotNull(personGetter.getById(person_id));
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
