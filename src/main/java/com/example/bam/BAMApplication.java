package com.example.bam;

import com.example.bam.Entities.CreditCard;
import com.example.bam.Entities.Person;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

@SpringBootApplication
public class BAMApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BAMApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private PersonRepository personRepository;



    @Override
    public void run(String... args)  {

    }
}
