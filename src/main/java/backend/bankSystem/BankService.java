package backend.bankSystem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    private final BankAccount_Repository bankAccount_repository;

    @Autowired
    public BankService(BankAccount_Repository bankAccountRepository) { bankAccount_repository = bankAccountRepository;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccount_repository.findAll();
    }

    public void newBankAccount(BankAccount bankAccount) {
        Optional<BankAccount> bankAccountOptional = bankAccount_repository
                .findByAccountHolder_uniqueCardNumber(bankAccount.getAccountHolder_Credit_Debit_Card());

        if (bankAccountOptional.isPresent()){
            throw new IllegalStateException("card number taken");
        }

        bankAccount_repository.save(bankAccount);
        System.out.println(bankAccount);
    }

    public void deleteBankAccount(Integer accountHolder_uniqueId) {
        Optional<BankAccount> bankAccountOptional = bankAccount_repository.findBankAccountByAccountHolder_uniqueId(accountHolder_uniqueId);

        if (!bankAccountOptional.isPresent()){
            throw new IllegalStateException("bank account with id: " + accountHolder_uniqueId + " does not exist");
        }

        bankAccount_repository.deleteById(accountHolder_uniqueId);
    }

    @Transactional
    public void updateBankAccount(Integer accountHolder_uniqueId,
                                  String accountHolder_Name,
                                  String accountHolderCreditDebitCard,
                                  Double accountHolder_Balance,
                                  String accountHolder_Status) {
        BankAccount bankAccount = bankAccount_repository
                .findBankAccountByAccountHolder_uniqueId(accountHolder_uniqueId)
                .orElseThrow(() -> new IllegalStateException("bank account with id: " + accountHolder_uniqueId + " does not exist"));

        if (accountHolder_Name != null){
            bankAccount.setAccountHolder_Name(accountHolder_Name);
        }
        if (accountHolderCreditDebitCard != null){
            Optional<BankAccount> bankAccountOptional = bankAccount_repository
                    .findByAccountHolder_uniqueCardNumber(bankAccount.getAccountHolder_Credit_Debit_Card());

            if (bankAccountOptional.isPresent()){
                throw new IllegalStateException("card number taken");
            }

            bankAccount.setAccountHolder_Credit_Debit_Card(accountHolderCreditDebitCard);
        }
        if (accountHolder_Balance != null){
            bankAccount.setAccountHolder_Balance(accountHolder_Balance);
        }
        if (accountHolder_Status != null){
            bankAccount.setAccountHolder_Status(accountHolder_Status);
        }
    }
}
