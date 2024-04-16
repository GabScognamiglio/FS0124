package it.esercizi;

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
    esWhile();
    }

    public static void esWhile(){

        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            System.out.println("Inserisci una stringa (:q per uscire):");
            input = scanner.nextLine();

            // Suddivide la stringa in caratteri separati da virgola e stampa il risultato
            if (!input.equals(":q")) {
                String[] caratteri = input.split("");
                String risultato = String.join(", ", caratteri);
                System.out.println(risultato);
            }
        } while (!input.equals(":q"));

    }
}
