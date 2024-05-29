package it.epicode.adapter;

import java.time.LocalDate;
import java.time.Period;

public class Info implements DataSource {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;


    @Override
    public String getNomeCompleto() {
        return getNome() + " " + getCognome();
    }

    @Override
    public int getEta() {
        Period eta = Period.between(getDataNascita(), LocalDate.now());
        return eta.getYears();
    }

    public Info(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }


}
