package com.control.client.services;

import com.control.client.entities.Client;
import com.control.client.repositories.ClientRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findClientByID(Long id) throws RuntimeException{
        return clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client Not found"));
    }
    public  void addClient (Client client){
        clientRepository.save(client);
    }
}
