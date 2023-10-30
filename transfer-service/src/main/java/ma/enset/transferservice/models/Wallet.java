package ma.enset.transferservice.models;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Wallet {
    private UUID id;
    private double balance;
    private Date creationDate;
    private String currency;
}
