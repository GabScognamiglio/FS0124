package it.epicode.es_giornaliero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private String cover;
    private int tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private Autore autore;

}


