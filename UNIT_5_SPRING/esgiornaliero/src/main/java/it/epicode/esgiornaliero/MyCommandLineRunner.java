package it.epicode.esgiornaliero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsgiornalieroApplication.class);









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
