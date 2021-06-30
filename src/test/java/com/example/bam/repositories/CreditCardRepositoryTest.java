package com.example.bam.repositories;

import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-test.properties")
class CreditCardRepositoryTest {

    private CreditCardRepository creditCardRepository;

    private PersonRepository personRepository;

    private static String card_id = "00";
    private static String person_id = "00";

    @Autowired
    public CreditCardRepositoryTest(CreditCardRepository creditCardRepository, PersonRepository personRepository) {
        this.creditCardRepository = creditCardRepository;
        this.personRepository = personRepository;
    }

    @Test
    void getCardById() {
        assertTrue(creditCardRepository.getCardById(card_id).isPresent());
    }

    @Test
    void getAll() {
        assertEquals(creditCardRepository.getAll().size(), 1);
    }

    @Test
    void getAllByUserId() {
        assertEquals(creditCardRepository.getAllByUserId(person_id).size(), 1);
    }

    @Test
    void cardById() {
        var all = this.creditCardRepository.getAll();
        var jj = this.creditCardRepository.cardById(card_id);
        assertEquals(card_id, this.creditCardRepository.cardById(card_id).get("cardNumber"));
    }

    @BeforeEach
    void preparePerson(){
        var m = IEntityService.personToEntity(Person.getTestPerson(person_id));
        personRepository.save(m);

        var c = IEntityService.creditCardToEntity(CreditCard.getTestCard(card_id, person_id));
        creditCardRepository.save(c);
    }

    @AfterEach
    void removePerson(){
        var person = personRepository.getPersonById(person_id);
        if (person.isPresent())
            personRepository.delete(person.get());
        else
            throw new NullPointerException();

        var card = creditCardRepository.findById(person_id);
        if (card.isPresent())
            creditCardRepository.delete(card.get());
        else
            throw new NullPointerException();
    }
}
