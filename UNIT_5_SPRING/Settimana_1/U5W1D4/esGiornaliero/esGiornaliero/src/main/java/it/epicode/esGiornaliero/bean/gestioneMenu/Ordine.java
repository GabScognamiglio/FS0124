package it.epicode.esGiornaliero.bean.gestioneMenu;

import it.epicode.esGiornaliero.bean.CibiMenu;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalTime;
import java.util.List;

@Data
@PropertySource("classpath:application.properties")
public class Ordine {
    private int numOrdine;
    private StatoOrdine statoOrdine;
    private int numCoperti;
    private LocalTime orario = LocalTime.now(); //valorizzato di base
    private List<CibiMenu> cibiOrdinati;
    //@Value("${costo.coperto}") //se lo va a prendere da application.properties (NO)
    private double costoCoperto = 3.0;
    @Autowired //se lo va a prendere dal contesto (?)
    private Tavolo tavolo;
    private double costoTotaleOrdine;

    public Ordine() {
    }

    public Ordine(@Value("${costo.coperto}") double costoCoperto, Tavolo tavolo) {
        this.costoCoperto = costoCoperto;
        this.tavolo = tavolo;
    }

    public double calcolaTotale() {
        double totaleCibi = this.cibiOrdinati.stream().map(c->c.getPrice()).reduce(0.0, Double::sum);
        double totaleCoperti = this.costoCoperto * this.numCoperti;

        return totaleCoperti + totaleCibi;
    }
}
