package com.control.voiture.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoitureResponse {
    private Long id;
    private String marque;
    private String model;
    private String matricule;
    private Client client;


}
