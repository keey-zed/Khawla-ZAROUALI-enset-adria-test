package ma.enset.transferservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.transferservice.enums.TransferStatus;

import java.util.Date;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class TransferDTO {
    private Long id;
    private Date date;
    private UUID sourceWalletId;
    private UUID destinationWalletId;
    private double amount;
    private TransferStatus status;
}
