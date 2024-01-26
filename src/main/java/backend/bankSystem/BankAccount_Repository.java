package backend.bankSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccount_Repository extends JpaRepository<BankAccount, Integer> {

    @Query("SELECT b FROM BankAccount b WHERE b.AccountHolder_Credit_Debit_Card = ?1")
    Optional<BankAccount> findByAccountHolder_uniqueCardNumber(String cardNumber);

    @Query("SELECT b FROM BankAccount b WHERE b.AccountHolder_uniqueId = ?1")
    Optional<BankAccount> findBankAccountByAccountHolder_uniqueId(Integer accountHolder_uniqueId);
}
