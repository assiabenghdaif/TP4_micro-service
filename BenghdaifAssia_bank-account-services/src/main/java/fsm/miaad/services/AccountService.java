package fsm.miaad.services;

import fsm.miaad.dto.BankAccountRequestDTO;
import fsm.miaad.dto.BankAccountResponseDTO;
import fsm.miaad.entities.BankAccount;

import java.util.List;

public interface AccountService {

    List<BankAccountResponseDTO> GetAll_bankAccounts();
    BankAccountResponseDTO GetById_bankAccount(String id);
    public BankAccountResponseDTO save_bankAccount(BankAccountRequestDTO bankAccountRequestDTO);
    public void delete_bankAccount(String id);
    public BankAccountResponseDTO update_bankAccount(BankAccountRequestDTO bankAccountRequestDTO,String id);
}
