package desafio.crudclientes.services;

import desafio.crudclientes.dtos.ClientDto;
import desafio.crudclientes.entities.Client;
import desafio.crudclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Recurso não encontrado")
        );
        return new ClientDto(client.getId(), client.getName(), client.getIncome(), client.getBirthDate(), client.getChilder());
    }
}
