package es3;

public class UsaRubrica {
    public static void main(String[] args) {
        RubricaTelefonica rubrica= new RubricaTelefonica();

        rubrica.aggiungiContatto("Gabriele","0665412365");
        rubrica.aggiungiContatto("Franco","3334445566");
        rubrica.aggiungiContatto("Peppe","3935698741");

        System.out.println(rubrica.cercaPerNome("Peppe"));

        rubrica.stampaRubrica();
    }
}
