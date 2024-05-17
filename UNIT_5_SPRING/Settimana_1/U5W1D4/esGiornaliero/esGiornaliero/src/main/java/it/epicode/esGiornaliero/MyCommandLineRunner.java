package it.epicode.esGiornaliero;

import it.epicode.esGiornaliero.bean.Ingrediente;
import it.epicode.esGiornaliero.bean.Pizza;
import it.epicode.esGiornaliero.service.CibiMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")

public class MyCommandLineRunner implements CommandLineRunner {


    @Autowired
    private CibiMenuService cibiMenuService;


    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsGiornalieroApplication.class);


//        Ingrediente i1 = ctx.getBean("pomodoro", Ingrediente.class);
//        cibiMenuService.inserisciCibo(i1);
//
//        Ingrediente i2 = ctx.getBean("mozzarella", Ingrediente.class);
//        cibiMenuService.inserisciCibo(i2);
//
//        Pizza p1 = ctx.getBean("margherita", Pizza.class);
//        cibiMenuService.inserisciCibo(p1);


        System.out.println(cibiMenuService.getPizzaById(154));


//
//        System.out.println();
//        System.out.println("***   MENU'   ***");
//        System.out.println();
//
//        Menu menu = ctx.getBean(Menu.class);
//
//        menu.getPizze().forEach(System.out::println);
//        System.out.println();
//        menu.getIngredienti().forEach(System.out::println);
//        System.out.println();
//        menu.getBevande().forEach(System.out::println);
//        System.out.println();
//
//        System.out.println();
//
//        Ordine ordine = ctx.getBean("ordine", Ordine.class);
//        System.out.println(ordine);
//        ordine.getCibiOrdinati().forEach(el -> System.out.println(el.getNome() + ": " + el.getPrice() + "€"));
//        System.out.println("Costo coperti: " + ordine.getCostoCoperto() * ordine.getNumCoperti()+ "€");
//        System.out.println("Prezzo finale: " + String.format("%.2f", ordine.getCostoTotaleOrdine())+ "€");
    }
}
