package com.example.bam;

import com.example.bam.repositories.BankAccountRepository;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.types.BankAccountType;
import com.example.bam.types.Entities.BankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@EnableJpaRepositories
@SpringBootApplication
public class BAMApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BAMApplication.class, args);
    }

    @Autowired
    private BankAccountRepository bar;

    @Bean
    CommandLineRunner runner(CreditCardRepository creditCardRepository, PersonRepository personRepository){
        return args -> {
            BankAccountEntity bae = new BankAccountEntity(1L, null, 0 , "000", null, BankAccountType.NORMAL);
            bar.save(bae);
            var peter = bar.findAll();
            System.out.println(peter.get(0));
            peter.get(0);
        };
    }
}
