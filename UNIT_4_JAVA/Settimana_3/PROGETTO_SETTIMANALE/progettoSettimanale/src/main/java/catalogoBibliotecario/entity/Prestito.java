package catalogoBibliotecario.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @OneToOne
    @JoinColumn(name = "elemento_prestato_id")
    private Pubblicazione elementoPrestato;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_fine_prestito")
    private LocalDate dataFinePrestito;
    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione;

    public Prestito(Utente utente, Pubblicazione elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzione) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataFinePrestito= dataInizioPrestito.plusDays(30);
        this.dataRestituzione = dataRestituzione;
    }

    public Prestito() {
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataFinePrestito=" + dataFinePrestito +
                ", dataRestituzione=" + dataRestituzione +
                '}';
    }

    public int getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Pubblicazione getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Pubblicazione elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataFinePrestito() {
        return dataFinePrestito;
    }

    public void setDataFinePrestito(LocalDate dataFinePrestito) {
        this.dataFinePrestito = dataFinePrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }
}
