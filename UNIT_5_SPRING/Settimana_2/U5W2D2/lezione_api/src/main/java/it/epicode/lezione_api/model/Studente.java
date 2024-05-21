package it.epicode.lezione_api.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Studente {
    private int matricola;
    private static int cont;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    public Studente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        cont++;
        matricola = cont;
    }
}
