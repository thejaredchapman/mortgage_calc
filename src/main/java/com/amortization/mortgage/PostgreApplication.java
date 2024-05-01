package com.amortization.mortgage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class PostgreApplication implements CommandLineRunner {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public static void main(String[] args) {
        SpringApplication.run(PostgreApplication.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO students (name, email) VALUES ("
                + "'Lahiru Ariyasinghe', 'lahiru@gmail.com')";
         
        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
 
}