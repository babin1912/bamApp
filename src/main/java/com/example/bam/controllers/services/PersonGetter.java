package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.IPersonGetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.EntitiesConvertorService;
import com.example.bam.services.interfaces.IEntityService;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonGetter implements IPersonGetter {

    private PersonRepository personRepository;

    private CreditCardRepository creditCardRepository;


    @Autowired
    public PersonGetter(PersonRepository personRepository, CreditCardRepository creditCardRepository) {
        this.personRepository = personRepository;
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Set<Person> getAllPeople() {
        return personRepository.getAll()
                .stream()
                .map(IEntityService::personFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Person getPersonById(long id) {
        return personRepository.getPersonById(id)
                .map(this::assignCreditCardsToPersonFromEntity)
                .orElse(null);
    }

    private Person assignCreditCardsToPersonFromEntity(PersonEntity personEntity) {
        var p = IEntityService.personFromEntity(personEntity);

        p.setCreditCards(
                creditCardRepository
                    .getAllByUserId(personEntity.getId())
                    .stream()
                    .map(IEntityService::creditCardFromEntity)
                    .collect(Collectors.toSet())
        );
        return p;
    }
}
