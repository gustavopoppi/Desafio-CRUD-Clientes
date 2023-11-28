package desafio.crudclientes.controllers;

import desafio.crudclientes.dtos.ClientDto;
import desafio.crudclientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable){
        Page<ClientDto> clientDto = clientService.findAll(pageable);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }

    @PostMapping()
    public ResponseEntity<ClientDto> insert(@RequestBody ClientDto clientDto){
        clientDto = clientService.insert(clientDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDto.id()).toUri();

        return ResponseEntity.created(uri).body(clientDto);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto){
        clientDto = clientService.update(id, clientDto);
        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ClientDto> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
