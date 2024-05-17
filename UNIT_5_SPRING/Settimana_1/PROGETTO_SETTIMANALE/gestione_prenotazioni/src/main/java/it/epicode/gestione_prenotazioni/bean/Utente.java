package it.epicode.gestione_prenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
}
