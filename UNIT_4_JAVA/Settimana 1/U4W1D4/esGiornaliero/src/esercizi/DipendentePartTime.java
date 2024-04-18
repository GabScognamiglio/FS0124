package esercizi;

public class DipendentePartTime extends Dipendente{

    private int oreGiorn;

    public DipendentePartTime(int matricola, Dipartimento dipartimento, int oreGiorn){
        super(matricola, dipartimento);
        this.oreGiorn=oreGiorn;
    }

    @Override
    public void calculateSalary() {
        this.setStipendio(1600/8*oreGiorn);
    }
}
