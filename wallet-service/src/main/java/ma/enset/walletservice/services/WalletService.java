package ma.enset.walletservice.services;

import jakarta.persistence.EntityNotFoundException;
import ma.enset.walletservice.dtos.WalletDTO;
import ma.enset.walletservice.entities.Wallet;
import ma.enset.walletservice.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.enset.walletservice.mappers.WalletMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(WalletDTO walletDTO) {
        Wallet wallet = WalletMapper.toWalletEntity(walletDTO);
        return walletRepository.save(wallet);
    }

    public WalletDTO getWalletById(UUID walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found with id: " + walletId));
        return WalletMapper.toWalletDTO(wallet);
    }

    public List<WalletDTO> getAllWallets() {
        List<Wallet> wallets = walletRepository.findAll();
        return wallets.stream()
                .map(WalletMapper::toWalletDTO)
                .collect(Collectors.toList());
    }

    public Wallet updateWallet(UUID walletId, WalletDTO walletDTO) {
        Wallet existingWallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found with id: " + walletId));
        Wallet updatedWallet = WalletMapper.toWalletEntity(walletDTO);
        updatedWallet.setId(existingWallet.getId());
        return walletRepository.save(updatedWallet);
    }

    public void deleteWallet(UUID walletId) {
        walletRepository.deleteById(walletId);
    }

    public List<Wallet> createWallets(List<WalletDTO> walletDTOs) {
        List<Wallet> wallets = walletDTOs.stream()
                .map(WalletMapper::toWalletEntity)
                .collect(Collectors.toList());
        return walletRepository.saveAll(wallets);
    }
}