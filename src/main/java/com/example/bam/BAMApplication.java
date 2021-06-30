package com.example.bam;

import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@EnableJpaRepositories
@SpringBootApplication
public class BAMApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, args[0]);
        SpringApplication.run(BAMApplication.class, args);
        System.out.println(msg);
    }

    @Autowired
    private static ConfigurableEnvironment env;

    @Value("${msg}")
    private static String msg;

    @Bean
    CommandLineRunner runner(CreditCardRepository creditCardRepository, PersonRepository personRepository){
        return args -> {
        };
    }
}
