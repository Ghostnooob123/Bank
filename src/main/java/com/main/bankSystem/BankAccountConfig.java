package com.main.bankSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.MARCH;

@Configuration
public class BankAccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(BankAccount_Repository repository){
        return args -> {
            BankAccount bankAccount1 = new BankAccount(1, "Ivo Rahnev", "4000 7684 2757 5786", 1771D,  LocalDate.of(2006, MARCH, 15));
            repository.saveAll(List.of(bankAccount1));
        };
    }
}

