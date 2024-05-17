package it.epicode.gestione_prenotazioni.bean;

import it.epicode.gestione_prenotazioni.bean.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descrizione;
    private TipoPostazione tipoPostazione;
    private int numMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}
