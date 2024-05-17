package it.epicode.gestione_prenotazioni.bean;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}
