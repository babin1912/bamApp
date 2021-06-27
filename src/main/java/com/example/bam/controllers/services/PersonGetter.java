package com.example.bam.controllers.services;

import com.example.bam.controllers.interfaces.IPersonGetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.services.EntitiesConvertorService;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(EntitiesConvertorService::personFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Person getPersonById(long id) {
        return personRepository.getPersonById(id)
                .map(EntitiesConvertorService::personFromEntity).orElse(null);
    }
}
