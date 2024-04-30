package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "studenti")
public class Studente {
    @Id
    @GeneratedValue
    private int matricola;
    @Column(nullable = false, length = 30)
    private String nome;
    @Column(nullable = false, length = 30)
    private String cognome;

    private String indirizzo;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    public Studente(int matricola, String nome, String cognome, String indirizzo, LocalDate dataNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
    }

    public Studente() {
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
}
