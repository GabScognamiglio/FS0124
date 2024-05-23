package it.epicode.es_giornaliero.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class PostDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    @URL
    private String cover;
    private int tempoDiLettura;
    @NotNull(message = "L'autore non può essere null")
    private int autoreId;

}
