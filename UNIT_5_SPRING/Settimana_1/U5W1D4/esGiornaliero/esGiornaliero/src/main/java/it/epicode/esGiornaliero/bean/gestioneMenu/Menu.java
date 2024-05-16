package it.epicode.esGiornaliero.bean.gestioneMenu;

import it.epicode.esGiornaliero.bean.Bevanda;
import it.epicode.esGiornaliero.bean.Ingrediente;
import it.epicode.esGiornaliero.bean.Pizza;
import lombok.Data;

import java.util.List;


@Data
public class Menu {
    private List<Pizza> pizze;
    private List<Ingrediente> ingredienti;
    private List<Bevanda> bevande;
}
