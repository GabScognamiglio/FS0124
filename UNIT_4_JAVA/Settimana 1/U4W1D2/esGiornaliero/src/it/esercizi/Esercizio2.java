package it.esercizi;

public class Esercizio2 {
    public static void main(String[] args) {
        esSwitch(1);
    }

    public static void esSwitch(int numero) {
        switch (numero) {
            case 0 :
                System.out.println("zero");
                break;
            case 1 :
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
            default:
                System.out.println("errore");
        }
    }
}
