package com.control.voiture.controller;


import com.control.voiture.entities.Voiture;
import com.control.voiture.models.VoitureResponse;
import com.control.voiture.repositories.VoitureRepository;
import com.control.voiture.services.VoitureService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/voiture")
public class VoitureController {
    @Autowired
    private VoitureService voitureService ;
    @Autowired
    private VoitureRepository voitureRepository;

    @GetMapping
    public List<VoitureResponse> getAll(){
        return voitureService.findAll();
    }
    @PostMapping
    public void addvoiture(@RequestBody Voiture voiture){
        voitureRepository.save(voiture);
    }
    @GetMapping("/{id}")
    public VoitureResponse getVoitureById(@PathVariable("id") Long id){
        return voitureService.findById(id);
    }
}
