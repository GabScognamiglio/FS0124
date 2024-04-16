package it.esercizi;

import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        int numeroInserito=scanner.nextInt();
        esFor(numeroInserito);

    }

    public static void esFor(int numero) {
        for (int i = numero; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
