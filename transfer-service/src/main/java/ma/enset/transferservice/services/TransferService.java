package ma.enset.transferservice.services;

import jakarta.persistence.EntityNotFoundException;
import ma.enset.transferservice.dtos.TransferDTO;
import ma.enset.transferservice.entities.Transfer;
import ma.enset.transferservice.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.enset.transferservice.mappers.TransferMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;

    public Transfer createTransfer(TransferDTO transferDTO) {
        Transfer transfer = TransferMapper.toTransferEntity(transferDTO);
        return transferRepository.save(transfer);
    }

    public TransferDTO getTransferById(Long transferId) {
        Transfer transfer = transferRepository.findById(transferId)
                .orElseThrow(() -> new EntityNotFoundException("Transfer not found with id: " + transferId));
        return TransferMapper.toTransferDTO(transfer);
    }

    public List<TransferDTO> getAllTransfers() {
        List<Transfer> transfers = transferRepository.findAll();
        return transfers.stream()
                .map(TransferMapper::toTransferDTO)
                .collect(Collectors.toList());
    }
}
