package fsm.miaad.services;

import fsm.miaad.dto.BankAccountRequestDTO;
import fsm.miaad.dto.BankAccountResponseDTO;
import fsm.miaad.entities.BankAccount;
import fsm.miaad.mappers.AccountMapper;
import fsm.miaad.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountService implements AccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;

    /**get all account in the database**/
    @Override
    public List<BankAccountResponseDTO> GetAll_bankAccounts(){
        List<BankAccount> bankAccounts=bankAccountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOS=new ArrayList<>();
        for(BankAccount account:bankAccounts)
            bankAccountResponseDTOS.add(AccountMapper.ENTITYtoDTO(account));
        return bankAccountResponseDTOS;
    }

    /**get account by id in the database**/
    @Override
    public BankAccountResponseDTO GetById_bankAccount(String id){
        BankAccount bankAccount= bankAccountRepository.findById(id)
                .orElse(null);

        return AccountMapper.ENTITYtoDTO(bankAccount);
        //Throw(()-> new IllegalStateException(String.format("Account %s not exist!!!, please try with another one.",id)));
    }

    /**insert an account in the database**/
    @Override
    public BankAccountResponseDTO save_bankAccount(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount= AccountMapper.DTOtoENTITY(bankAccountRequestDTO);
        BankAccount savedBankAccount= bankAccountRepository.save(bankAccount);
        return AccountMapper.ENTITYtoDTO(savedBankAccount);
    }

    /**delete an account **/
    @Override
    public void delete_bankAccount(String id){
        boolean Accountfounded=bankAccountRepository.existsById(id);
        if(Accountfounded)
            bankAccountRepository.deleteById(id);
    }

    /**update an account **/
    @Override
    public BankAccountResponseDTO update_bankAccount(BankAccountRequestDTO  bankAccountRequestDTO, String id)
    {
        boolean Accountfounded=bankAccountRepository.existsById(id);
        if(Accountfounded) {
            BankAccount account=bankAccountRepository.findById(id).orElse(null);
            account.setBalance(bankAccountRequestDTO.getBalance());
            account.setCurrency(bankAccountRequestDTO.getCurrency());
            account.setCreatedAt(new Date());
            account.setType(bankAccountRequestDTO.getType());

            BankAccount bankAccount=bankAccountRepository.save(account);
            return AccountMapper.ENTITYtoDTO(bankAccount);
        }
        return null;
    }



}
