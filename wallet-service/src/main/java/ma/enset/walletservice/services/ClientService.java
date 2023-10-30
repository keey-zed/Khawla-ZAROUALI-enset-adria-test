package ma.enset.walletservice.services;

import jakarta.persistence.EntityNotFoundException;
import ma.enset.walletservice.dtos.ClientDTO;
import ma.enset.walletservice.entities.Client;
import ma.enset.walletservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.enset.walletservice.mappers.ClientMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toClientEntity(clientDTO);
        return clientRepository.save(client);
    }

    public ClientDTO getClientDTOById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        return ClientMapper.toClientDTO(client);
    }

    public Client getClientById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        return client;
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    public Client updateClient(Long clientId, ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        Client updatedClient = ClientMapper.toClientEntity(clientDTO);
        updatedClient.setId(existingClient.getId());
        return clientRepository.save(updatedClient);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public List<Client> createClients(List<ClientDTO> clientDTOs) {
        List<Client> clients = clientDTOs.stream()
                .map(ClientMapper::toClientEntity)
                .collect(Collectors.toList());
        return clientRepository.saveAll(clients);
    }
}