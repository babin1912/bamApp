package com.example.bam.controllers.interfaces;

import com.example.bam.types.Person;

import java.util.Set;
import java.util.Optional;

public interface IPersonGetter {
    Set<Person> getAllPeople();
    Person getPersonById(long id);
}
