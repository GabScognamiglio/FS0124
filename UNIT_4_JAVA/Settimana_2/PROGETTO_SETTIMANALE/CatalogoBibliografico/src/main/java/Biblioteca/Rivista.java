package Biblioteca;

public class Rivista extends Pubblicazione{
    private Periodicita periodicita;

    public Rivista(long codiceISBN, String title, int numPagine, int anno, Periodicita periodicita) {
        super(codiceISBN, title, numPagine, anno);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
