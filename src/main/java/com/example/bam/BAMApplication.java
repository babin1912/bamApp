package com.example.bam;

import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;


@EnableJpaRepositories
@SpringBootApplication
public class BAMApplication {

    public static void main(String[] args) {
        SpringApplication.run(BAMApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private PersonRepository personRepository;



    @Bean
    CommandLineRunner runner(CreditCardRepository creditCardRepository, PersonRepository personRepository){
        return args -> {
        };
    }
}
