package it.epicode.gestione_dispositivi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "dipendenti")
@Data
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String immagineProfilo;

    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivi;
}
