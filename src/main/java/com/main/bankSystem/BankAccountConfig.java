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
            BankAccount bankAccount = BankAccount.BankAccountBuilder()
                    .AccountHolderUniqueId(1)
                    .AccountHolderName("Ivo Rahnev")
                    .AccountHolderCreditDebitCard("4000 7684 2757 5786")
                    .AccountHolderBalance(1771D)
                    .AccountHolderDob(LocalDate.of(2006, MARCH, 15))
                    .build();
            repository.saveAll(List.of(bankAccount));
        };
    }
}

