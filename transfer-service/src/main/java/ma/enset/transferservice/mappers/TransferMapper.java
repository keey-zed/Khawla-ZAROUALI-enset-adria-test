package ma.enset.transferservice.mappers;

import ma.enset.transferservice.dtos.TransferDTO;
import ma.enset.transferservice.entities.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {

    public static TransferDTO toTransferDTO(Transfer transfer) {
        if (transfer == null) {
            return null;
        }

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setId(transfer.getId());
        transferDTO.setDate(transfer.getDate());
        transferDTO.setSourceWalletId(transfer.getSourceWallet().getId());
        transferDTO.setDestinationWalletId(transfer.getDestinationWallet().getId());
        transferDTO.setAmount(transfer.getAmount());
        transferDTO.setStatus(transfer.getStatus());
        return transferDTO;
    }

    public static Transfer toTransferEntity(TransferDTO transferDTO) {
        if (transferDTO == null) {
            return null;
        }

        Transfer transfer = new Transfer();
        transfer.setId(transferDTO.getId());
        transfer.setDate(transferDTO.getDate());
        transfer.setAmount(transferDTO.getAmount());
        transfer.setStatus(transferDTO.getStatus());
        return transfer;
    }
}
