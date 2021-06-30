package com.example.bam.controllers;

import com.example.bam.controllers.interfaces.ITypeGetter;
import com.example.bam.controllers.interfaces.ITypeSetter;
import com.example.bam.controllers.services.PersonGetter;
import com.example.bam.controllers.services.PersonSetter;
import com.example.bam.types.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Controller for people
 */
@RestController
public class PersonController {

    private ITypeGetter<Person> personGetter;

    private ITypeSetter<Person> personSetter;

    @Autowired
    public PersonController(PersonGetter personGetter, PersonSetter personSetter) {
        this.personGetter = personGetter;
        this.personSetter = personSetter;
    }

    /**
     * Returning all people in system
     * @return set of found people
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Set<Person> getAllPeople() {
        return personGetter.getAll();
    }

    /**
     * Returns person with given id
     * @param personId
     * @return response with person in body
     */
    @RequestMapping(value = "/find/{personId}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Person> getPersonById(@PathVariable String personId) {
        return getPersonByIdResponse(personId);
    }

    /**
     * Saving new person in system
     * @param person that is gonna be save
     * @return response with message
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String>  saveNewPerson(@RequestBody Person person) {
        try {
            personSetter.saveNew(person);
            return new ResponseEntity<>("Person was saved", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>( "Person or one of cards already exists",HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<Person> getPersonByIdResponse(String personId) {
        Person p = personGetter.getById(personId);
        return p != null ? new ResponseEntity<>(p, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
