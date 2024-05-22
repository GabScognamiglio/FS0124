package it.epicode.es_giornaliero.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Autore {
    private int id;
    private static int contatore;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String avatar;

    public Autore(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        contatore++;
        id=contatore;
        avatar="https://ui-avatars.com/api/?name=" + this.getNome() + "+" + this.getCognome();
    }
}
