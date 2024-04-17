package rettangolo;

public class UsaRettangolo {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(10,2);
        Rettangolo rettangolo1 = new Rettangolo(50,30);
        Rettangolo rettangolo2 = new Rettangolo(16,10);

        rettangolo1.stampaDueRettangoli(rettangolo1, rettangolo2);
        rettangolo.stampaRettangolo(rettangolo);

        rettangolo.setAltezza(50);
        rettangolo.stampaRettangolo(rettangolo);
    }
}
