package com.control.voiture.models;

import jakarta.persistence.Table;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
    private Long id;
    private String nom;
    private Integer age;
}
