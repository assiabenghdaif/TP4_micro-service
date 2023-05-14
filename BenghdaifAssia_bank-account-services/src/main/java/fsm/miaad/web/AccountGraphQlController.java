package fsm.miaad.web;

import fsm.miaad.dto.BankAccountRequestDTO;
import fsm.miaad.dto.BankAccountResponseDTO;
import fsm.miaad.entities.BankAccount;
import fsm.miaad.repositories.BankAccountRepository;
import fsm.miaad.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {

    @Autowired
    private BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccountResponseDTO> getAll_accounts(){
        return bankAccountService.GetAll_bankAccounts();
    }

    @QueryMapping
    public BankAccountResponseDTO getById_account(@Argument String id){
        return bankAccountService.GetById_bankAccount(id);
    }

    @MutationMapping
    public BankAccountResponseDTO save_account(@Argument BankAccountRequestDTO bankAccountRequestDTO){
        return bankAccountService.save_bankAccount(bankAccountRequestDTO);
    }

    @MutationMapping
    public BankAccountResponseDTO update_account(@Argument BankAccountRequestDTO bankAccountRequestDTO,@Argument String id){
        return bankAccountService.update_bankAccount(bankAccountRequestDTO,id);
    }

    @QueryMapping
    public String delete_account(@Argument String id){
        bankAccountService.delete_bankAccount(id);
        return "OK";
    }
}
