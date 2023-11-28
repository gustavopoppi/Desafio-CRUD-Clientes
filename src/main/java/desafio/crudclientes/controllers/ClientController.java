package desafio.crudclientes.controllers;

import desafio.crudclientes.dtos.ClientDto;
import desafio.crudclientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }
}
