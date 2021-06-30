package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.ITypeSetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.CreditCard;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for getting people from repository
 */
@Service
public class PersonSetter implements ITypeSetter<Person> {

    private PersonRepository personRepository;

    private CreditCardRepository creditCardRepository;

    private ITypeSetter<CreditCard> creditCardSetter;

    @Autowired
    public PersonSetter(PersonRepository personRepository, CreditCardRepository creditCardRepository, ITypeSetter<CreditCard> creditCardSetter) {
        this.personRepository = personRepository;
        this.creditCardRepository = creditCardRepository;
        this.creditCardSetter = creditCardSetter;
    }

    /**
     * Saving new person in repository
     * @param person
     * @return saved person
     * @throws Exception when person or card already exists in repository
     */
    @Override
    public Person saveNew(Person person) throws Exception {
        if (personRepository.getPersonById(person.getId()).isPresent()) throw new Exception("Person already exists");
        if (person.getCreditCards()
                .stream().anyMatch(this::cardAlreadyExists)) throw new Exception("Card already exists");

        this.personRepository.save(IEntityService.personToEntity(person));
        ITypeSetter<CreditCard> creditCardITypeSetter = creditCardSetter;
        for (CreditCard creditCard : person.getCreditCards()) {
            creditCardITypeSetter.saveNew(creditCard);
        }

        return person;
    }

    /**
     * checks if card is allready saved in repository
     * @param creditCard
     * @return result
     */
    private boolean cardAlreadyExists(CreditCard creditCard)  {
        return creditCard.getId() == null || creditCardRepository.findById(creditCard.getId()).isPresent();
    }
}
