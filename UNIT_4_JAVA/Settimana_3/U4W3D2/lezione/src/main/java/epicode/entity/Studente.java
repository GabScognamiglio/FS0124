package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


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
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @OneToOne
    @JoinColumn (name="indirizzo_id")
    private Indirizzo indirizzo;
    //lato proprietario, è sempre quello MANY e ha la JoinColumn
    @ManyToOne
    @JoinColumn(name = "classe_studenti_id")
    private ClasseStudenti classeStudenti;
    //lato proprietario del ManyToMany
    @ManyToMany
    @JoinTable(name = "studenti_corsi",
            joinColumns = @JoinColumn(name = "studenti_id"),
            inverseJoinColumns = @JoinColumn(name = "corsi_id"))
    private List<Corso> corsi;

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita, Indirizzo indirizzo) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo=indirizzo;
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
                ", dataNascita=" + dataNascita +
                ", indirizzo=" + indirizzo +
                '}';
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    public ClasseStudenti getClasseStudenti() {
        return classeStudenti;
    }

    public void setClasseStudenti(ClasseStudenti classeStudenti) {
        this.classeStudenti = classeStudenti;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
}
