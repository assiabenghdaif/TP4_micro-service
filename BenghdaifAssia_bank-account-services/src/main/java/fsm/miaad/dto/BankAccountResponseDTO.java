package fsm.miaad.dto;

import fsm.miaad.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {

    private  String id;
    private Date createdAt;
    private double balance;
    private  String currency;
    private AccountType type;
}
