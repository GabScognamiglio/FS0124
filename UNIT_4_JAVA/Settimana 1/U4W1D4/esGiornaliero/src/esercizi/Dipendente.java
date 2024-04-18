package esercizi;

public abstract class Dipendente {
    private int matricola;
    private double stipendio;
    private Dipartimento dipartimento;


    public Dipendente(int matricola, Dipartimento dipartimento) {
        this.matricola = matricola;

        this.dipartimento = dipartimento;
    }

    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public abstract void calculateSalary();
}
