package it.esercizi;

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Inserisci primo lato rettangolo");
        double latorett1 = scanner.nextDouble();

        System.out.println("Inserisci secondo lato rettangolo");
        double latorett2 = scanner.nextDouble();

        System.out.println("Il perimetro del rettangolo è: " + perimetroRettangolo(latorett1, latorett2));

        System.out.println("Inserisci un numero per verificare se è pari o dispari: ");
        int pariDisp = scanner.nextInt();
        System.out.println(pariDispari(pariDisp));

        System.out.println("Inserisci primo lato triangolo: ");
        double latotr1= scanner.nextDouble();
        System.out.println("Inserisci secondo lato triangolo: ");
        double latotr2= scanner.nextDouble();
        System.out.println("Inserisci terzo lato triangolo: ");
        double latotr3= scanner.nextDouble();

        System.out.println(perimetroTriangolo(latotr1, latotr2, latotr3));
    }

    public static double perimetroRettangolo (double lato1, double lato2) {
        return (lato1 * 2) + (lato2 * 2);
    }

    public static int pariDispari(int numero){
       return numero%2;
    }

    public static double perimetroTriangolo (double lato1, double lato2, double lato3) {
        return (lato1 + lato2 + lato3);
    }
}
