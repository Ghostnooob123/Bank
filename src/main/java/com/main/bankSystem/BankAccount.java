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
    private String AccountHolder_Status;
    private LocalDate AccountHolder_Dob;
    private LocalDate AccountHolder_LastTransactionDate;
    @Transient
    private LocalDate AccountHolder_CreatedOn;
    @Transient
    private Integer AccountHolder_Age;

    protected Integer getAccountHolder_Age(){
        return Period.between(getAccountHolder_Dob(), LocalDate.now()).getYears();
    }

    protected void setAccountHolder_uniqueId(Integer new_AccountHolder_uniqueId){
        AccountHolder_uniqueId = new_AccountHolder_uniqueId;
        AccountHolder_Status = "Active";
    }
    protected void setAccountHolder_Balance(Double new_AccountHolder_Balance){
        if (AccountHolder_Status.equals("Active")){
            AccountHolder_Balance = new_AccountHolder_Balance;
            AccountHolder_LastTransactionDate = LocalDate.now();
        }
        else{
            throw new IllegalStateException("Inactive account");
        }
    }

    protected BankAccount(){
        AccountHolder_Status = "Active";
        AccountHolder_CreatedOn = LocalDate.now();
    }

    // Static method to get a builder instance
    protected static BankAccountBuilder BankAccountBuilder() {
        return new BankAccountBuilder();
    }

}
