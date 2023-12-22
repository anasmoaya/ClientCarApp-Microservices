package com.control.voiture.entities;

import com.ctc.wstx.evt.WstxEventReader;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voiture")
public class Voiture {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marque;
    private String model;
    private String matricule;
    private Long client_id;

}
