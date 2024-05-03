package gestioneeventi.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 30)
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEVento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numMaxPartecipanti;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "evento", fetch = FetchType.EAGER) //lato inverso
    private List<Partecipazione> listaPartecipazioni;


    public Evento(String titolo, LocalDate dataEvento, TipoEVento tipoEvento, int numMaxPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numMaxPartecipanti = numMaxPartecipanti;
    }

    public Evento() {
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", numMaxPartecipanti=" + numMaxPartecipanti +
                '}';
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public TipoEVento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEVento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumMaxPartecipanti() {
        return numMaxPartecipanti;
    }

    public void setNumMaxPartecipanti(int numMaxPartecipanti) {
        this.numMaxPartecipanti = numMaxPartecipanti;
    }
}
