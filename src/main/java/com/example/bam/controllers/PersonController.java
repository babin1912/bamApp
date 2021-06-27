package com.example.bam.controllers;

import com.example.bam.controllers.interfaces.IPersonGetter;
import com.example.bam.controllers.services.PersonGetter;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class PersonController {

    private IPersonGetter personGetter;

    @Autowired
    public PersonController(PersonGetter personGetter) {
        this.personGetter = personGetter;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Person> getAllPeople() {
        return personGetter.getAllPeople();
    }

    @RequestMapping(value = "/all/{personId}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable long personId) {
        return personGetter.getPersonById(personId);
    }


}
