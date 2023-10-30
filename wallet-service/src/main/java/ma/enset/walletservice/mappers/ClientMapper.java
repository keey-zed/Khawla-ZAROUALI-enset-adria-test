package ma.enset.walletservice.mappers;

import ma.enset.walletservice.dtos.ClientDTO;
import ma.enset.walletservice.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public static ClientDTO toClientDTO(Client client) {
        if (client == null) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        return clientDTO;
    }

    public static Client toClientEntity(ClientDTO clientDTO) {
        if (clientDTO == null) {
            return null;
        }

        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        return client;
    }
}