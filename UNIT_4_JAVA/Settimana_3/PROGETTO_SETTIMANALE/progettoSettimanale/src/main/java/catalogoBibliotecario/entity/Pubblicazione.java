package catalogoBibliotecario.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "pubblicazioni")
public abstract class Pubblicazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codice_ISBN")
    private long codiceISBN;
    @Column(length = 30)
    private String title;
    private int anno;
    @Column(name = "numero_pagine")
    private int numPagine;

    public Pubblicazione(String title, int numPagine, int anno) {
        this.title = title;
        this.numPagine = numPagine;
        this.anno = anno;
    }

    public Pubblicazione() {
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "codiceISBN=" + codiceISBN +
                ", title='" + title + '\'' +
                ", anno=" + anno +
                ", numPagine=" + numPagine +
                '}';
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
