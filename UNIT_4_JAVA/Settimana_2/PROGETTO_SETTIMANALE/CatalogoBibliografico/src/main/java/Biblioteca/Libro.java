package Biblioteca;

public class Libro extends Pubblicazione{
    private String autore;
    private String genere;

    public Libro(long codiceISBN, String title, int numPagine, int anno, String autore, String genere) {
        super(codiceISBN, title, numPagine, anno);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
