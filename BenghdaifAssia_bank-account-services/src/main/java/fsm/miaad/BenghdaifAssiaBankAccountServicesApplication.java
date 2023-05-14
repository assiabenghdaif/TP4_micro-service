package fsm.miaad;

import fsm.miaad.entities.BankAccount;
import fsm.miaad.enums.AccountType;
import fsm.miaad.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BenghdaifAssiaBankAccountServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenghdaifAssiaBankAccountServicesApplication.class, args);
		System.out.println("the service was lanced on http://localhost:2001/bankAccounts");
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for(int i=0;i<10;i++){
				BankAccount bankAccount= BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(2001+Math.random()*2001)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}
}
