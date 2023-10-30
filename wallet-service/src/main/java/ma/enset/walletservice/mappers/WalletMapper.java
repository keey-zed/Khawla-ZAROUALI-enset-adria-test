package ma.enset.walletservice.mappers;

import ma.enset.walletservice.dtos.WalletDTO;
import ma.enset.walletservice.entities.Wallet;
import ma.enset.walletservice.services.ClientService;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    public static WalletDTO toWalletDTO(Wallet wallet) {
        if (wallet == null) {
            return null;
        }

        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(wallet.getId());
        walletDTO.setBalance(wallet.getBalance());
        walletDTO.setCreationDate(wallet.getCreationDate());
        walletDTO.setCurrency(wallet.getCurrency());
        if (wallet.getOwner() != null) {
            walletDTO.setOwnerId(wallet.getOwner().getId());
        }
        return walletDTO;
    }

    public static Wallet toWalletEntity(WalletDTO walletDTO) {
        if (walletDTO == null) {
            return null;
        }

        Wallet wallet = new Wallet();
        wallet.setId(walletDTO.getId());
        wallet.setBalance(walletDTO.getBalance());
        wallet.setCreationDate(walletDTO.getCreationDate());
        wallet.setCurrency(walletDTO.getCurrency());
        ClientService clientService = null;
        wallet.setOwner(clientService.getClientById(walletDTO.getOwnerId()));
        return wallet;
    }
}