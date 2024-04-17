package rettangolo;

public class Rettangolo {
    private int base;
    private int altezza;

    public Rettangolo(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public void stampaRettangolo(Rettangolo rettangolo){
        System.out.println("L'area del rettangolo è: " + (rettangolo.base*rettangolo.altezza));
        System.out.println("Il perimetro del rettangolo è: " + rettangolo.base*2+rettangolo.altezza*2);
    }

    public void stampaDueRettangoli(Rettangolo rett1, Rettangolo rett2){
        System.out.println("La somma delle aree dei rettangoli è: " + (rett1.base*rett1.altezza + rett2.base*rett2.altezza));
        System.out.println("La somma dei perimetri dei rettangoli è: " + (rett1.base*2 + rett1.altezza*2 + rett2.base*2 + rett2.altezza*2));
    }

    public int getAltezza() {
        return altezza;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
}
