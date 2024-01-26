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
    public void registerBankAccount(@RequestBody BankAccount bankAccount){
        bankService.newBankAccount(bankAccount);
    }
    @DeleteMapping(path = "{accountHolder_uniqueId}")
    public void deleteBankAccount(@PathVariable("accountHolder_uniqueId") Integer accountHolder_uniqueId) {
        bankService.deleteBankAccount(accountHolder_uniqueId);
    }
    @PutMapping(path={"{accountHolder_uniqueId}"})
    public void updateStudent(@PathVariable("accountHolder_uniqueId") Integer accountHolder_uniqueId,
                              @RequestParam(required = false) String accountHolder_Name,
                              @RequestParam(required = false) String accountHolder_Credit_Debit_Card,
                              @RequestParam(required = false) Double accountHolder_Balance,
                              @RequestParam(required = false) String accountHolder_Status) {
        bankService.updateBankAccount(accountHolder_uniqueId,
                accountHolder_Name,
                accountHolder_Credit_Debit_Card,
                accountHolder_Balance,
                accountHolder_Status);
    }
}
