package catalogoBibliotecario.entity;

import catalogoBibliotecario.entity.enums.Periodicita;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends Pubblicazione{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(long codiceISBN, String title, int numPagine, int anno, Periodicita periodicita) {
        super(title, numPagine, anno);
        this.periodicita = periodicita;
    }

    public Rivista() {
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "codiceISBN=" + getCodiceISBN() +
                ", title='" + getTitle() + '\'' +
                ", anno=" + getAnno() +
                ", numPagine=" + getNumPagine() +
                ", periodicita=" + periodicita +
                '}';
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
