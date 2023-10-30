package ma.enset.transferservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.transferservice.enums.TransferStatus;
import ma.enset.transferservice.models.Wallet;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Transfer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Transient
    private Wallet sourceWallet;
    @Transient
    private Wallet destinationWallet;
    private double amount;
    @Enumerated(EnumType.STRING)
    private TransferStatus status;
}

