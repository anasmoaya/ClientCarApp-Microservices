package com.control.client.controller;


import com.control.client.entities.Client;
import com.control.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping
    private List<Client> getClients(){
        return  service.findAll();
    }
    @GetMapping("/{id}")
    private Client getClientByID(@PathVariable("id") Long id) throws RuntimeException{
        return  service.findClientByID(id);
    }

    @PostMapping
    private void addClient(@RequestBody  Client client){
        service.addClient(client);
    }

}
