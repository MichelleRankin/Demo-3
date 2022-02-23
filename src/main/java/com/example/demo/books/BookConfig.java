package com.example.demo.books;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args ->{
            Book mariam = new Book(
                    "The light in the Sky",
                    "Mariam Jamal",
                    LocalDate.of(2000, JANUARY, 5)
            );
            Book alex = new Book(
                    "Depths of the Ocean",
                    "Alec Benjamin",
                    LocalDate.of(2004, JANUARY, 5)
            );
            Book attack = new Book(
                    "Attack on Titan",
                    "some author",
                    LocalDate.of(1986, MARCH, 9)
            );

            repository.saveAll(
                    List.of(mariam, alex, attack)
            );


        };
    }
}
