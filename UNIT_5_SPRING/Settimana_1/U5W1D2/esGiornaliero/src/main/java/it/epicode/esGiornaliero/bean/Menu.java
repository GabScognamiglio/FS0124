package it.epicode.esGiornaliero.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
public class Menu {
    private List<Pizza> pizze;
    private List<Ingrediente> ingredienti;
    private List<Bevanda> bevande;
}
