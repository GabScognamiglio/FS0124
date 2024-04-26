package Biblioteca;

public abstract class Pubblicazione {
    private long codiceISBN;
    private String title;
    private int anno;
    private int numPagine;

    public Pubblicazione(long codiceISBN, String title, int numPagine, int anno) {
        this.codiceISBN = codiceISBN;
        this.title = title;
        this.numPagine = numPagine;
        this.anno = anno;
    }

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }
}
