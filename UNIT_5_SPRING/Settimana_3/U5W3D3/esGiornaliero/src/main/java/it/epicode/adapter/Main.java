package it.epicode.adapter;

import java.time.LocalDate;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {

        UserData u1 = new UserData("Gabriele Scognamiglio", 29);

        Info u2 = new Info("Gabriele", "Scognamiglio", LocalDate.of(1995,2,16));

        System.out.println(u1.getNomeCompleto());
        System.out.println(u2.getNomeCompleto());

        System.out.println(u1.getEta());
        System.out.println(u2.getEta());



        //Semplicemente un test di faker, visto sulla soluzione all'esercizio in piattaforma
        Faker faker = new Faker(Locale.ITALIAN);

        System.out.println(faker.color().hex());
    }
}