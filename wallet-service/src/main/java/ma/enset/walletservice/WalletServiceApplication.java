package ma.enset.walletservice;

import ma.enset.walletservice.dtos.ClientDTO;
import ma.enset.walletservice.dtos.WalletDTO;
import ma.enset.walletservice.repositories.ClientRepository;
import ma.enset.walletservice.repositories.WalletRepository;
import ma.enset.walletservice.services.ClientService;
import ma.enset.walletservice.services.WalletService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientService clientService, WalletService walletService) {
		return args -> {
			List<ClientDTO> clientDTOs = Arrays.asList(
					ClientDTO.builder().name("PARK Jimin").email("PJM95@example.com").build(),
					ClientDTO.builder().name("JEON Jungkook").email("JJK97@example.com").build()
			);

			List<WalletDTO> walletDTOs = Arrays.asList(
					WalletDTO.builder().balance(1000.0).currency("USD").ownerId(1L).build(),
					WalletDTO.builder().balance(500.0).currency("EUR").ownerId(2L).build()
			);

			clientService.createClients(clientDTOs);
			walletService.createWallets(walletDTOs);
		};
	}

}
