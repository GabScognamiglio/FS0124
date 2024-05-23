package it.epicode.es_giornaliero.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autori")
@Data
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String email;
    private String avatar;
    @OneToMany(mappedBy = "autore")
    private List<Post> posts;


    public Autore() {
    }

    public Autore(String nome, String cognome, LocalDate dataNascita, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.email = email;
        this.avatar = "https://ui-avatars.com/api/?name=" + getNome() + "+" + getCognome();
    }
}
