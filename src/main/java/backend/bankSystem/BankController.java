package backend.bankSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
    @GetMapping
    public List<BankAccount> bankAccounts (){
        return bankService.getBankAccounts();
    }
    @PostMapping()
    public String registerBankAccount(@RequestBody BankAccount newBankAccount){

        bankService.newBankAccount(newBankAccount);

        return "New bank account registered with id: " + newBankAccount.getAccountHolder_Name();
    }
    @DeleteMapping(path = "{accountHolder_uniqueId}")
    public void deleteBankAccount(@PathVariable("accountHolder_uniqueId") Integer accountHolder_uniqueId) {
        bankService.deleteBankAccount(accountHolder_uniqueId);
    }
    @PutMapping(path={"{accountHolder_uniqueId}"})
    public String updateBankAccount(@PathVariable("accountHolder_uniqueId") Integer accountHolder_uniqueId,
                                  @RequestBody BankAccount updateBankAccount) {

        bankService.updateBankAccount(accountHolder_uniqueId, updateBankAccount);

        return "Updated bank account: " + accountHolder_uniqueId;
    }
}
