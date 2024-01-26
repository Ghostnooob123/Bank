package backend.bankSystem;

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

    public BankAccountBuilder AccountHolderDob(LocalDate accountHolder_Dob) {
        newBankAccount.setAccountHolder_Dob(accountHolder_Dob);
        return this;
    }

    public BankAccountBuilder AccountHolderStatus(String accountHolder_Status){
        newBankAccount.setAccountHolder_Status(accountHolder_Status);
        return this;
    }

    public BankAccountBuilder AccountHolderCreatedOn(LocalDate accountHolder_CreatedOn){
        newBankAccount.setAccountHolder_CreatedOn(accountHolder_CreatedOn);
        return this;
    }

    public BankAccountBuilder AccountHolderAge(Integer accountHolder_Age) {
        newBankAccount.setAccountHolder_Age(accountHolder_Age);
        return this;
    }

    public BankAccount build() {
        return newBankAccount;
    }
}
