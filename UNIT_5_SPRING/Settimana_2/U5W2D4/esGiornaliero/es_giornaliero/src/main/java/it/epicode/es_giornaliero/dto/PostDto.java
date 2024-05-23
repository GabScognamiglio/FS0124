package it.epicode.es_giornaliero.dto;

import lombok.Data;

@Data
public class PostDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    private String cover;
    private int tempoDiLettura;
    private int autoreId;

}
