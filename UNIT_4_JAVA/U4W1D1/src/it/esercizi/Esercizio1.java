package it.esercizi;

import java.util.Arrays;

public class Esercizio1 {
    public static void main(String[] args) {
        System.out.println(prodotto(8, 8));

        System.out.println(concatena("Mario ", 50));

        String[] arr1 = {"primo", "secondo", "terzo", "quarto", "quinto"};
        String str1 = "SESTO";

        System.out.println(Arrays.toString(InserisciInArray(arr1,str1)));
    }

    public static int prodotto(int a, int b) {
        return a * b;
    }

    public static String concatena(String a, int b) {
        return a+b;
    }

    public static String[] InserisciInArray(String[] array, String stringa) {
        String[] arrayFinale = new String[6];
        for (int i = 0; i < array.length + 1; i++) {
            if (i < 2) {
                arrayFinale[i] = array[i];
            } else if(i==2){
                arrayFinale[i]=stringa;
            } else {
                arrayFinale[i]=array[i - 1];
            }
        }

        return arrayFinale;
    }
}
