package it.epicode.esgiornaliero.appConfig;

import it.epicode.esgiornaliero.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class AppConfig {
    @Bean
    public Bevanda getAcqua() {
        Bevanda acqua = new Bevanda();
        acqua.setNome("Acqua");
        acqua.setCalorie(0);
        acqua.setPrice(1.99);
        acqua.setQuantitaCl(50);

        return acqua;
    }

    @Bean
    public Bevanda getLimonata() {
        Bevanda limonata = new Bevanda();
        limonata.setNome("Limonata");
        limonata.setCalorie(100);
        limonata.setPrice(2.99);
        limonata.setQuantitaCl(33);

        return limonata;
    }

    @Bean
    public BevandaAlcolica getVino() {
        BevandaAlcolica vino = new BevandaAlcolica();
        vino.setNome("Vino");
        vino.setGradazione(13);
        vino.setQuantitaCl(75);
        vino.setCalorie(510);
        vino.setPrice(15.80);

        return vino;
    }

    @Bean
    public Ingrediente getPomodoro() {
        Ingrediente pomodoro = new Ingrediente();
        pomodoro.setNome("Pomodoro");
        pomodoro.setCalorie(92);
        pomodoro.setPrice(0.69);

        return pomodoro;
    }

    @Bean
    public Ingrediente getMozzarella() {
        Ingrediente mozzarella = new Ingrediente();
        mozzarella.setNome("Mozzarella");
        mozzarella.setCalorie(92);
        mozzarella.setPrice(0.69);

        return mozzarella;
    }

    @Bean
    public Ingrediente getProsciutto() {
        Ingrediente prosciutto = new Ingrediente();
        prosciutto.setNome("Prosciutto");
        prosciutto.setCalorie(35);
        prosciutto.setPrice(0.99);

        return prosciutto;
    }

    @Bean
    public Ingrediente getCipolla() {
        Ingrediente cipolla = new Ingrediente();
        cipolla.setNome("Cipolla");
        cipolla.setCalorie(22);
        cipolla.setPrice(0.69);

        return cipolla;
    }

    @Bean
    public Ingrediente getAnanas() {
        Ingrediente ananas = new Ingrediente();
        ananas.setNome("Ananas");
        ananas.setCalorie(24);
        ananas.setPrice(0.79);

        return ananas;
    }

    @Bean
    public Ingrediente getSalami() {
        Ingrediente salami = new Ingrediente();
        salami.setNome("Salami");
        salami.setCalorie(86);
        salami.setPrice(0.99);

        return salami;
    }

    @Bean
    public Pizza getMargherita() {
        Pizza margherita = new Pizza();
        margherita.setNome("Margherita");
        margherita.setCalorie(1104);
        margherita.setPrice(4.99);
      //  margherita.setIngredienti(List.of(getPomodoro(), getMozzarella()));

        return margherita;
    }

    @Bean
    public Pizza getHawaiian() {
        Pizza hawaiian = new Pizza();
        hawaiian.setNome("Hawaiian");
        hawaiian.setPrice(6.49);
        hawaiian.setCalorie(1500);
       // hawaiian.setIngredienti(List.of(getPomodoro(), getMozzarella(), getProsciutto(), getAnanas()));

        return hawaiian;
    }

    @Bean
    public Pizza getSalamiPizza() {
        Pizza salami = new Pizza();
        salami.setNome("Salami");
        salami.setPrice(5.99);
        salami.setCalorie(1307);
       //salami.setIngredienti(List.of(getPomodoro(), getMozzarella(), getSalami()));

        return salami;
    }

    @Bean
    public Menu getMenu() {
        Menu menu = new Menu();
        menu.setPizze(List.of(getMargherita(), getHawaiian(), getSalamiPizza()));
        menu.setIngredienti(List.of(getMozzarella(), getProsciutto(), getCipolla(), getAnanas(), getSalami()));
        menu.setBevande(List.of(getLimonata(), getAcqua(), getVino()));

        return menu;
    }

    @Bean
    public Tavolo tavolo(){
        Tavolo tavolo = new Tavolo();
        tavolo.setNumTavolo(1);
        tavolo.setMaxCoperti(5);
        tavolo.setStato(StatoTavolo.LIBERO);

        return tavolo;
    }
    @Bean("ordine")
    public Ordine ordine() {
        Ordine ordine = new Ordine();
        ordine.setNumOrdine(2);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setCibiOrdinati(List.of(getMargherita(), getSalamiPizza(), getVino(), getAcqua()));
        ordine.setNumCoperti(4);
        ordine.setCostoTotaleOrdine(ordine.calcolaTotale());


        return ordine;

    }

}
