package ma.enset.walletservice.controllers;

import ma.enset.walletservice.dtos.WalletDTO;
import ma.enset.walletservice.entities.Wallet;
import ma.enset.walletservice.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ma.enset.walletservice.mappers.WalletMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletDTO> createWallet(@RequestBody WalletDTO walletDTO) {
        Wallet wallet = walletService.createWallet(walletDTO);
        return new ResponseEntity<>(WalletMapper.toWalletDTO(wallet), HttpStatus.CREATED);
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<WalletDTO> getWallet(@PathVariable UUID walletId) {
        WalletDTO walletDTO = walletService.getWalletById(walletId);
        return new ResponseEntity<>(walletDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WalletDTO>> getAllWallets() {
        List<WalletDTO> wallets = walletService.getAllWallets();
        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }

    @PutMapping("/{walletId}")
    public ResponseEntity<WalletDTO> updateWallet(@PathVariable UUID walletId, @RequestBody WalletDTO walletDTO) {
        Wallet updatedWallet = walletService.updateWallet(walletId, walletDTO);
        return new ResponseEntity<>(WalletMapper.toWalletDTO(updatedWallet), HttpStatus.OK);
    }

    @DeleteMapping("/{walletId}")
    public ResponseEntity<Void> deleteWallet(@PathVariable UUID walletId) {
        walletService.deleteWallet(walletId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}