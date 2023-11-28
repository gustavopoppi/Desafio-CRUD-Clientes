package desafio.crudclientes.services;

import desafio.crudclientes.dtos.ClientDto;
import desafio.crudclientes.entities.Client;
import desafio.crudclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(this::criaClientDto);
    }

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Recurso não encontrado")
        );
        return criaClientDto(client);
    }

    @Transactional(readOnly = true)
    public ClientDto insert(ClientDto clientDto) {
        Client entity = new Client();

        return copiaDtoToEntityESalva(clientDto, entity);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto clientDto) {
        Client entity = clientRepository.getReferenceById(id);

        return copiaDtoToEntityESalva(clientDto, entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientDto criaClientDto(Client client){
        return new ClientDto(client.getId(), client.getName(), client.getIncome(), client.getBirthDate(), client.getChildren());
    }

    private ClientDto copiaDtoToEntityESalva(ClientDto clientDto, Client entity) {
        entity.setName(clientDto.name());
        entity.setIncome(clientDto.income());
        entity.setBirthDate(clientDto.birthDate());
        entity.setChildren(clientDto.children());
        clientRepository.save(entity);

        return criaClientDto(entity);
    }
}
