package it.esercizi;

public class Esercizio1 {

    public static void main(String[] args) {
        System.out.println(stringaPariDispari("ciao"));
        System.out.println(annoBisesto(2024));
    }

    public static boolean stringaPariDispari(String stringa){
        if (stringa.length()%2==0){
            return true;
        } else {
            return false;
        }
    }

    public static boolean annoBisesto (int anno) {
        if (anno%4==0){
            return true;
        } else {
            return false;
        }
    }
}
