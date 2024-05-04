package catalogoBibliotecario.entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tessera_seq")
    @SequenceGenerator(name = "tessera_seq", sequenceName = "tessera_seq", initialValue = 1000)
    @Column(name = "numero_tessera")
    private int numeroTessera;
    @Column(length = 30)
    private String nome;
    @Column(length = 30)
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    public Utente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public Utente() {
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
}
