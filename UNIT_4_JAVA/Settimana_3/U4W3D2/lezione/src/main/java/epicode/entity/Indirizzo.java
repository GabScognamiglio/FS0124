package epicode.entity;

import javax.persistence.*;

@Entity
@Table(name = "indirizzi")
public class Indirizzo {
    @Id
    @GeneratedValue
    private int id;
    private String via;
    private String comune;
    private String provincia;


    @OneToOne(mappedBy = "indirizzo", fetch = FetchType.EAGER)
    private Studente studente;

    public Indirizzo(String via, String comune, String provincia) {
        this.via = via;
        this.comune = comune;
        this.provincia = provincia;
    }

    public Indirizzo() {
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "via='" + via + '\'' +
                ", comune='" + comune + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
