package fsm.miaad.mappers;

import fsm.miaad.dto.BankAccountRequestDTO;
import fsm.miaad.dto.BankAccountResponseDTO;
import fsm.miaad.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {

    public static BankAccount DTOtoENTITY(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount=new BankAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
        return bankAccount;
    }

    public static BankAccountResponseDTO ENTITYtoDTO(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
