package com.example.bam.controllers;

import com.example.bam.controllers.interfaces.IPersonGetter;
import com.example.bam.controllers.interfaces.IPersonSetter;
import com.example.bam.controllers.services.PersonGetter;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PersonController {

    private IPersonGetter personGetter;

    private IPersonSetter personSetter;

    @Autowired
    public PersonController(PersonGetter personGetter, IPersonSetter personSetter) {
        this.personGetter = personGetter;
        this.personSetter = personSetter;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Set<Person> getAllPeople() {
        return personGetter.getAllPeople();
    }

    @RequestMapping(value = "/find/{personId}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Person> getPersonById(@PathVariable long personId) {
        return getPersonByIdResponse(personId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String>  saveNewPerson(@RequestBody Person person) {
        try {
            personSetter.saveNewPerson(person);
            return new ResponseEntity<>("Person was saved", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>( "Person or one of cards already exists",HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<Person> getPersonByIdResponse(long personId) {
        Person p = personGetter.getPersonById(personId);
        return p != null ? new ResponseEntity<>(p, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
