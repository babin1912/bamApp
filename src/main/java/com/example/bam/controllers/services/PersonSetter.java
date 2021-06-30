package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.ICreditCardSetter;
import com.example.bam.controllers.interfaces.ITypeSetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonSetter implements ITypeSetter<Person> {

    private PersonRepository personRepository;

    private CreditCardRepository creditCardRepository;

    private ICreditCardSetter creditCardSetter;

    @Autowired
    public PersonSetter(PersonRepository personRepository, CreditCardRepository creditCardRepository, ICreditCardSetter creditCardSetter) {
        this.personRepository = personRepository;
        this.creditCardRepository = creditCardRepository;
        this.creditCardSetter = creditCardSetter;
    }

    @Override
    public Person saveNewPerson(Person person) throws Exception {
        if (personRepository.getPersonById(person.getId()).isPresent()) throw new Exception("Person already exists");
        if (person.getCreditCards()
                .stream().anyMatch(this::cardAlreadyExists)) throw new Exception("Card already exists");

        this.personRepository.save(IEntityService.personToEntity(person));
        person.getCreditCards()
                .forEach(creditCardSetter::saveNewCard);

        return person;
    }

    private boolean cardAlreadyExists(CreditCard creditCard)  {
        return creditCard.getId() == null || creditCardRepository.findById(creditCard.getId()).isPresent();
    }
}
