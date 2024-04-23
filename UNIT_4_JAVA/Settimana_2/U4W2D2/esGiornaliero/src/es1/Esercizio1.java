package es1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Inserisci il numero di parole da inserire: ");
        int N = scanner.nextInt();

        Set<String> parole = new HashSet<>();

        System.out.println("Inserisci le parole una per una:");
        for (int i = 0; i < N; i++) {
            String parola = scanner.next();
            if (!parole.add(parola)) {
                System.out.println("Parola duplicata: " + parola);
            }
        }

        System.out.println("Numero di parole distinte: " + parole.size());
        System.out.println("Elenco delle parole distinte:");
        for (String parola : parole) {
            System.out.println(parola);
        }

    }
}
