package com.example.bam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BAMApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BAMApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        // String sql = "insert into person values(1);";
        /*String sql = "insert into person (firstname, lastname) values('peter', 'malackyy');";


        if (jdbcTemplate.update(sql) > 0) System.out.println("nice");*/
    }
}
