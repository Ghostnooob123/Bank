package com.main.bankSystem;


import java.time.LocalDate;

public class BankAccountBuilder {
    private final BankAccount newBankAccount = new BankAccount();

    public BankAccountBuilder AccountHolderUniqueId(Integer accountHolder_uniqueId) {
        newBankAccount.setAccountHolder_uniqueId(accountHolder_uniqueId);
        return this;
    }
    public BankAccountBuilder AccountHolderName(String accountHolder_Name) {
        newBankAccount.setAccountHolder_Name(accountHolder_Name);
        return this;
    }

    public BankAccountBuilder AccountHolderCreditDebitCard(String accountHolder_Credit_Debit_Card) {
        newBankAccount.setAccountHolder_Credit_Debit_Card(accountHolder_Credit_Debit_Card);
        return this;
    }

    public BankAccountBuilder AccountHolderBalance(Double accountHolder_Balance) {
        newBankAccount.setAccountHolder_Balance(accountHolder_Balance);
        return this;
    }

    public BankAccountBuilder AccountHolderDob(LocalDate accountHolderDob) {
        newBankAccount.setAccountHolder_Dob(accountHolderDob);
        return this;
    }

    public BankAccountBuilder AccountHolderAge(Integer accountHolderAge) {
        newBankAccount.setAccountHolder_Age(accountHolderAge);
        return this;
    }

    public BankAccount build() {
        return newBankAccount;
    }
}
