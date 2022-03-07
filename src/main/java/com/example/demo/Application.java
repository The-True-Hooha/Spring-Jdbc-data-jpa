package com.example.demo;

import com.example.demo.Entity.Customers;
import com.example.demo.Repository.CustomersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (CustomersRepository customersRepository) {
        return args -> {
            Customers bigBen = new Customers("ben",
                    "bright",
                    "kingbright@gmail.com",
                    "0902223331",
                    "12 Akpu street",
                    33);
            customersRepository.save(bigBen);
        };
    }
}
