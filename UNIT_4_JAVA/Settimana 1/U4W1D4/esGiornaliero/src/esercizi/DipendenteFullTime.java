package esercizi;

public class DipendenteFullTime extends Dipendente{
    private int oreGiorn=8;

    public DipendenteFullTime(int matricola, Dipartimento dipartimento){
        super(matricola, dipartimento);
        double stipendio;
    }

    @Override
    public void calculateSalary() {
        this.setStipendio(1600);
    }
}
