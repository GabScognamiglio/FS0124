package telefonia;

import java.util.Arrays;

public class SimCard {
    private int numero;
    private int credito;
    private Chiamata[] ultimeCinque;

    public SimCard(int numero) {
        this.numero = numero;
        this.ultimeCinque = new Chiamata[5];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Chiamata[] getUltimeCinque() {
        return ultimeCinque;
    }

    public void setUltimeCinque(Chiamata[] ultimeCinque) {
        this.ultimeCinque = ultimeCinque;
    }

    public void stampaSim(){
        System.out.println("Numero di telefono: " + this.numero);
        System.out.println("Credito residuo: " + this.credito);
        System.out.println("Ultime chiamate effettuate: " );
        for (Chiamata chiamata:this.ultimeCinque) {
            System.out.println(chiamata); //stampa indirizzo di memoria
        }
    }


}
