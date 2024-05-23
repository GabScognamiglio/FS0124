package it.epicode.lezione_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Studente {
    @Id
    @GeneratedValue
    private int matricola;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String foto;
    private String email;

    @ManyToOne
    @JoinColumn(name="aula_id")
    @JsonIgnore
    private Aula aula;

}
