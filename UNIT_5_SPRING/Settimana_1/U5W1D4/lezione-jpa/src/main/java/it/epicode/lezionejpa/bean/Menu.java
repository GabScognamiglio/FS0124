package it.epicode.lezionejpa.bean;

import lombok.Data;

import java.util.List;


@Data
public class Menu {
    private List<Pizza> pizze;
    private List<Ingrediente> ingredienti;
    private List<Bevanda> bevande;
}
