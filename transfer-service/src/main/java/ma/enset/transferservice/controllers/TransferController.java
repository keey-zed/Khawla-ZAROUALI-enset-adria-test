package ma.enset.transferservice.controllers;

import ma.enset.transferservice.dtos.TransferDTO;
import ma.enset.transferservice.entities.Transfer;
import ma.enset.transferservice.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ma.enset.transferservice.mappers.TransferMapper;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferDTO> createTransfer(@RequestBody TransferDTO transferDTO) {
        Transfer transfer = transferService.createTransfer(transferDTO);
        return new ResponseEntity<>(TransferMapper.toTransferDTO(transfer), HttpStatus.CREATED);
    }

    @GetMapping("/{transferId}")
    public ResponseEntity<TransferDTO> getTransfer(@PathVariable Long transferId) {
        TransferDTO transferDTO = transferService.getTransferById(transferId);
        return new ResponseEntity<>(transferDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransferDTO>> getAllTransfers() {
        List<TransferDTO> transfers = transferService.getAllTransfers();
        return new ResponseEntity<>(transfers, HttpStatus.OK);
    }
}