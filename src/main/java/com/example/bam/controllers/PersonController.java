package com.example.bam.controllers;

import com.example.bam.controllers.interfaces.IPersonGetter;
import com.example.bam.controllers.services.PersonGetter;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/get/{personId}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonById(@PathVariable long personId) {
        return getPersonByIdResponse(personId);
    }

    private ResponseEntity<Person> getPersonByIdResponse(long personId) {
        Person p = personGetter.getPersonById(personId);
        return p != null ? new ResponseEntity<>(p, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
