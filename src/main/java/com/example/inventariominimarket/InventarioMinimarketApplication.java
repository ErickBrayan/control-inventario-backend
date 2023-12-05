package com.example.inventariominimarket;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class InventarioMinimarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioMinimarketApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
        };
    }

}
