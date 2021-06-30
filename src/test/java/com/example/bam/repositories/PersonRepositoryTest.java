package com.example.bam.repositories;

import com.example.bam.controllers.services.PersonGetter;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import play.db.Database;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-test.properties")
class PersonRepositoryTest {


    private PersonRepository personRepository;

    @Autowired
    public PersonRepositoryTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private static String person_id = "01";


    @Test
    void getAll() {
        assertEquals(personRepository.getAll().size(), 1);
    }

    @Test
    void getPersonById() {
        assertFalse(personRepository.getPersonById(person_id).isEmpty());
    }

    @BeforeEach
    void preparePerson(){
        var m = IEntityService.personToEntity(Person.getTestPerson(person_id));
        personRepository.save(m);
    }
    @AfterEach
    void removePerson(){
        var person = personRepository.getPersonById(person_id);
        if (person.isPresent())
            personRepository.delete(person.get());
        else
            throw new NullPointerException();
    }
}
