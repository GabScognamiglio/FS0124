package it.esercizi;

import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Scrivi la prima stringa:");
        String str1=scanner.nextLine();
        System.out.println("Scrivi la seconda stringa:");
        String str2=scanner.nextLine();
        System.out.println("Scrivi la terza stringa:");
        String str3=scanner.nextLine();

        System.out.println(str1 + " " + str2 + " " + str3);
        System.out.println(str3 + " " + str2 + " " + str1);

    }
}
