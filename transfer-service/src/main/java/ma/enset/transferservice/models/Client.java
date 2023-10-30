package ma.enset.transferservice.models;

import lombok.Data;

import java.util.List;

@Data
public class Client {
    private Long id;
    private String name;
    private String email;
}
