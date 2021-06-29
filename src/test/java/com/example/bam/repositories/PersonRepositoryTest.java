package com.example.bam.repositories;

import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import play.db.Database;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

/*    Database database =
            Databases.createFrom("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test");*/

    @Test
    void itShouldGetPersonById() {
        /*// given
        Long id = 1400L;
        PersonEntity person = new PersonEntity(id,"peter", "janiga", 'M', 0);
        underTest.save(person);
        // when
        Optional<PersonEntity> result = underTest.getPersonById(id);
        //then
        assertTrue(result.get().getId() == person.getId());*/

    }

    @Test
    void getAll() {
    }
}
