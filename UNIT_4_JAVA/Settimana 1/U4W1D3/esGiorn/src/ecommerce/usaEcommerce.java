package ecommerce;

import java.util.Calendar;
import java.util.Date;

public class usaEcommerce {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("12A5D", "Gabriele", "Scognamiglio", "gab@sco.it", new Date(121, Calendar.FEBRUARY, 10));

        cliente.stampaCliente();
        System.out.println(" ");
        Articolo articolo1 = new Articolo("14D75TYH46S66", "Smartwatch Samsung", 459, 150);
        Articolo articolo2 = new Articolo("14D75TYH12345", "TV LG", 1199, 30);
        Articolo articolo3 = new Articolo("1465454243AA5", "Smartphone Motorola", 869, 80);
        articolo1.stampaArticolo();
        System.out.println(" ");
        articolo2.stampaArticolo();
        System.out.println(" ");
        articolo3.stampaArticolo();

        Carrello carrello = new Carrello(cliente);
        carrello.addToCart(articolo1);
        carrello.addToCart(articolo2);
        carrello.addToCart(articolo3);

        System.out.println(" ");
        System.out.println("Il totale del carrello è: €" + carrello.totaleCarrello());
    }
}
