package esercizi;

public class Dirigente extends Dipendente{
    public Dirigente(int matricola, Dipartimento dipartimento){
        super(matricola, dipartimento);
    }

    @Override
    public void calculateSalary() {
        this.setStipendio(5000);
    }

}
