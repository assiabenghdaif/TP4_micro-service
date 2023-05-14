package fsm.miaad.web;

import fsm.miaad.dto.BankAccountRequestDTO;
import fsm.miaad.dto.BankAccountResponseDTO;
import fsm.miaad.entities.BankAccount;
import fsm.miaad.repositories.BankAccountRepository;
import fsm.miaad.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/bankAccounts/")
public class AccountRestController {

    private BankAccountService bankAccountService;

    public AccountRestController(BankAccountService bankAccountService){
        this.bankAccountService=bankAccountService;
    }

    /**get all account in the database**/
    @GetMapping("allAccounts")
    public List<BankAccountResponseDTO> bankAccounts(){
        return bankAccountService.GetAll_bankAccounts();
    }

    /**get account by id in the database**/
    @GetMapping("getAccountById/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id){
        return bankAccountService.GetById_bankAccount(id);
    }

    @PostMapping("saveAccount")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return bankAccountService.save_bankAccount(bankAccountRequestDTO);
    }

    @PutMapping("updateAccount/{id}")
    public BankAccountResponseDTO  updateAccount(@PathVariable String id,@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return bankAccountService.update_bankAccount(bankAccountRequestDTO, id);
    }

    @DeleteMapping("deleteAccount/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable String id){
        bankAccountService.delete_bankAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

