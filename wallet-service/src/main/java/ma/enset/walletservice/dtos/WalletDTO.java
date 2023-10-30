package ma.enset.walletservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class WalletDTO {
    private UUID id;
    private double balance;
    private Date creationDate;
    private String currency;
    private Long ownerId;
}