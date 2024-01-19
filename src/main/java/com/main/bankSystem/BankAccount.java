package com.main.bankSystem;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@ToString

@Entity
@Table
public class BankAccount {
    @Id
    @SequenceGenerator(
            name = "bankAccount_sequence",
            sequenceName = "bankAccount_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bankAccount_sequence"
    )
    private Integer AccountHolder_uniqueId;
    private String AccountHolder_Name;
    private String AccountHolder_Credit_Debit_Card;
    private Double AccountHolder_Balance;
    private LocalDate AccountHolder_Dob;
    @Transient
    private Integer AccountHolder_Age;
    @Transient
    private LocalDate AccountHolder_CreatedAt;
    @Transient
    private LocalDate AccountHolder_LastTransactionDate;

    public BankAccount(Integer accountHolder_uniqueId, String accountHolder_Name, String accountHolder_Credit_Debit_Card, Double accountHolder_Balance,  LocalDate accountHolder_Dob) {
        AccountHolder_uniqueId = accountHolder_uniqueId;
        AccountHolder_Name = accountHolder_Name;
        AccountHolder_Credit_Debit_Card = accountHolder_Credit_Debit_Card;
        AccountHolder_Balance = accountHolder_Balance;
        AccountHolder_Dob = accountHolder_Dob;

        AccountHolder_CreatedAt = LocalDate.now();
    }

    public BankAccount(String accountHolder_Name, String accountHolder_Credit_Debit_Card, Double accountHolder_Total, LocalDate accountHolder_Dob) {
        AccountHolder_Name = accountHolder_Name;
        AccountHolder_Credit_Debit_Card = accountHolder_Credit_Debit_Card;
        AccountHolder_Balance = accountHolder_Total;
        AccountHolder_Dob = accountHolder_Dob;

        AccountHolder_CreatedAt = LocalDate.now();
    }

    public BankAccount(){
        AccountHolder_CreatedAt = LocalDate.now();
    }

    protected Integer getAccountHolder_Age(){
        return Period.between(getAccountHolder_Dob(), LocalDate.now()).getYears();
    }

    protected void setAccountHolder_Balance(Double new_setAccountHolder_Balance){
        AccountHolder_Balance = new_setAccountHolder_Balance;
        AccountHolder_LastTransactionDate = LocalDate.now();
    }

}
