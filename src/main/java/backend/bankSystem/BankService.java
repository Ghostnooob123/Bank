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

    public void newBankAccount(BankAccount newBankAccount) {
        Optional<BankAccount> bankAccountOptional = bankAccount_repository
                .findByAccountHolder_uniqueCardNumber(newBankAccount.getAccountHolder_Credit_Debit_Card());

        if (bankAccountOptional.isPresent()){
            throw new IllegalStateException("card number taken");
        }

        bankAccount_repository.save(newBankAccount);
    }

    public void deleteBankAccount(Integer accountHolder_uniqueId) {
        Optional<BankAccount> bankAccountOptional = bankAccount_repository.findBankAccountByAccountHolder_uniqueId(accountHolder_uniqueId);

        if (!bankAccountOptional.isPresent()){
            throw new IllegalStateException("bank account with id: " + accountHolder_uniqueId + " does not exist");
        }

        bankAccount_repository.deleteById(accountHolder_uniqueId);
    }

    @Transactional
    public void updateBankAccount(Integer accountHolder_uniqueId, BankAccount updateBankAccount) {
       BankAccount bankAccount = bankAccount_repository
                .findBankAccountByAccountHolder_uniqueId(accountHolder_uniqueId)
                .orElseThrow(() -> new IllegalStateException("bank account with id: " + accountHolder_uniqueId + " does not exist"));

        if (updateBankAccount.getAccountHolder_Name() != null){
            bankAccount.setAccountHolder_Name(updateBankAccount.getAccountHolder_Name());
        }
        if (updateBankAccount.getAccountHolder_Credit_Debit_Card() != null){
            Optional<BankAccount> bankAccountOptional = bankAccount_repository
                    .findByAccountHolder_uniqueCardNumber(bankAccount.getAccountHolder_Credit_Debit_Card());

            if (bankAccountOptional.isPresent()){
                throw new IllegalStateException("card number taken");
            }

            bankAccount.setAccountHolder_Credit_Debit_Card(updateBankAccount.getAccountHolder_Credit_Debit_Card());
        }
        if (updateBankAccount.getAccountHolder_Balance() != null){
            bankAccount.setAccountHolder_Balance(updateBankAccount.getAccountHolder_Balance());
        }
        if (updateBankAccount.getAccountHolder_Status() != null){
            bankAccount.setAccountHolder_Status(updateBankAccount.getAccountHolder_Status());
        }
    }
}
