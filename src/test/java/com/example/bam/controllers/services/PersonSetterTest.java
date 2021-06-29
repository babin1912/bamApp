package com.example.bam.controllers.services;

import com.example.bam.controllers.PersonController;
import com.example.bam.controllers.interfaces.ICreditCardGetter;
import com.example.bam.controllers.interfaces.ICreditCardSetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@DataJpaTest
@ExtendWith(MockitoExtension.class)/*
@RunWith(SpringJUnit4ClassRunner.class)*/
class PersonSetterTest {


    @Autowired
    TestEntityManager entityManager;

    private PersonSetter personSetter = Mockito.mock(PersonSetter.class);

    @Mock
    private CreditCardSetter creditCardSetter = Mockito.mock(CreditCardSetter.class);

    @Mock
    private PersonRepository personRepository = Mockito.mock(PersonRepository.class);

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    /*@Before
    public void createMocks() {
        MockitoAnnotations.initMocks(this);
    }*/

    public PersonSetterTest() throws Exception {
         this.personSetter = new PersonSetter(personRepository, null,creditCardSetter );

    }

    @Test
    void saveNewPerson() throws Exception {
        Person originalPerson = new Person();
        originalPerson.setFirstName("magda");
        originalPerson.setId(2000L);
        var newPerson = personSetter.saveNewPerson(originalPerson);
        assertTrue(originalPerson.getId() == newPerson.getId());
    }
}
