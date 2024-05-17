package it.epicode.gestione_prenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "prenotazioni", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"postazione_id", "dataPrenotazione"})
})
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dataPrenotazione;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

}