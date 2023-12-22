package com.control.client.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @Column(name = "id", nullable = false)

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Float age;

}