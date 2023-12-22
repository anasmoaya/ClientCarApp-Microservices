package com.control.voiture.services;

import com.control.voiture.entities.Voiture;
import com.control.voiture.models.VoitureResponse;
import com.control.voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.control.voiture.models.Client;

import java.util.Arrays;
import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-CLIENT";
    public List<VoitureResponse> findAll(){
        List<Voiture> voitures = voitureRepository.findAll();
        ResponseEntity<Client[]>  response = restTemplate.getForEntity(this.URL+"/api/client" , Client[].class);
        Client[] clients = response.getBody();
        return  voitures.stream().map((Voiture voiture) -> mapToVoitureResponse(voiture , clients)
        ).toList();
    }
    private VoitureResponse mapToVoitureResponse(Voiture voiture , Client [] clients){
        Client foundClient = Arrays.stream(clients)
                .filter(client -> client.getId().equals(voiture.getClient_id()))
                .findFirst()
                .orElse(null);
        return VoitureResponse.builder()
                .id(voiture.getId())
                .model(voiture.getModel())
                .marque(voiture.getMarque())
                .matricule(voiture.getMatricule())
                .client(foundClient)
                .build();
    }

    public VoitureResponse findById(Long id) throws RuntimeException{
        Voiture voiture = voitureRepository.findById(id).orElseThrow(()->new RuntimeException("voiture not found"));
        Client client = restTemplate.getForObject(this.URL+"/api/client/" + voiture.getClient_id() , Client.class);
        return VoitureResponse.builder()
                .id(voiture.getId())
                .marque(voiture.getMarque())
                .client(client)
                .matricule(voiture.getMatricule())
                .model(voiture.getModel())
                .build();

    }
}
