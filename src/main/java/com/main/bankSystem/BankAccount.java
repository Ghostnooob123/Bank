package com.main.bankSystem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table
public class BankAccount {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Integer AccountHolder_uniqueNumber;
    private String AccountHolder_Name;
    private String AccountHolder_Credit_Debit_Card;
    private Double AccountHolder_Total;

    public BankAccount(Integer accountHolder_uniqueNumber, String accountHolder_Name, String accountHolder_Credit_Debit_Card, Double accountHolder_Total) {
        AccountHolder_uniqueNumber = accountHolder_uniqueNumber;
        AccountHolder_Name = accountHolder_Name;
        AccountHolder_Credit_Debit_Card = accountHolder_Credit_Debit_Card;
        AccountHolder_Total = accountHolder_Total;
    }
}
