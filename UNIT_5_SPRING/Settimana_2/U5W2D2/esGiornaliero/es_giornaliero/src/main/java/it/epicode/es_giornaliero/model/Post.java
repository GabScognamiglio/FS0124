package it.epicode.es_giornaliero.model;

import lombok.Data;

@Data
public class Post {
    private int id;
    private static int contatore;
    private String categoria;
    private String titolo;
    private String cover;
    private int tempoDiLettura;

    public Post(String categoria, String titolo, String cover, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.tempoDiLettura = tempoDiLettura;
        contatore++;
        id=contatore;
    }
}


