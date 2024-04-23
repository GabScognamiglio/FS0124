package es3;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Set;

public class RubricaTelefonica {
    private HashMap<String, String> rubrica;

    public RubricaTelefonica() {
        rubrica = new HashMap<String, String>(); //numero telefonico in formato String perchè i prefissi possono iniziare con 0
    }

    public void aggiungiContatto(String nome, String numero){
        rubrica.put(nome,numero);
    }

    public void rimuoviContatto(String nome){
        rubrica.remove(nome);
    }

    public String cercaPerNome(String nome){
        return rubrica.get(nome);
    }

    public boolean cercaPerNumero(String numero){
        return rubrica.containsValue(numero);
    }

    public void stampaRubrica(){
        Set<String> nomi = rubrica.keySet();

        for (String nome:nomi){
            System.out.println(nome + ": " + rubrica.get(nome));
        }
    }
}
