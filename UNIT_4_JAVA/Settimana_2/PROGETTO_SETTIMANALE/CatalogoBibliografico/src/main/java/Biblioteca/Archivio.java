package Biblioteca;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Archivio {
    public static void main(String[] args) throws IOException {
        Map<Long, Pubblicazione> archivio = new HashMap(); //mappa con ISBN come chiave(univoco) e Pubblicazione come valore
        File file = new File("./../persistence/archivio.txt"); //creo file di testo per scrivere e leggere

        //IL CODICE QUI SOTTO È STATO SCRITTO PRIMA DELLA CREAZIONE E LETTURA DEL FILE, AL FINE PROPRIO DI POPOLARE IL FILE

//        Pubblicazione libro1 = new Libro(9780132350884L, "Clean Code", 464, 2008, "Robert C. Martin", "Sviluppo software");
//        Pubblicazione libro2 = new Libro(9788820360420L, "Il Signore degli Anelli", 1216, 1954, "J.R.R. Tolkien", "Fantasy");
//        Pubblicazione libro3 = new Libro(9788804653721L, "Harry Potter e la Pietra Filosofale", 336, 1997, "J.K. Rowling", "Fantasy");
//        Pubblicazione libro4 = new Libro(9788876257142L, "1984", 368, 1949, "George Orwell", "Romanzo distopico");
//        Pubblicazione libro5 = new Libro(9788806181349L, "Cronache del ghiaccio e del fuoco: Il Trono di Spade", 640, 1996, "George R.R. Martin", "Fantasy");
//        Pubblicazione libro6 = new Libro(9788807900305L, "Dune", 672, 1965, "Frank Herbert", "Fantascienza");
//
//        Pubblicazione rivista1 = new Rivista(9770005452006L, "National Geographic", 160, 2024, Periodicita.MENSILE);
//        Pubblicazione rivista2 = new Rivista(9771128504009L, "Time", 96, 2024, Periodicita.SETTIMANALE);
//        Pubblicazione rivista3 = new Rivista(9772037113003L, "The Economist", 96, 2024, Periodicita.SETTIMANALE);
//        Pubblicazione rivista4 = new Rivista(9770399055004L, "Vanity Fair", 180, 2024, Periodicita.MENSILE);
//        Pubblicazione rivista5 = new Rivista(9771121926005L, "Scientific American", 80, 2024, Periodicita.MENSILE);
//        Pubblicazione rivista6 = new Rivista(9770004021003L, "Wired", 112, 2024, Periodicita.MENSILE);
//
//        //METODI PER L'AGGIUNTA DI PUBBLICAZIONI IN ARICHIVIO
//        archivio.put(libro1.getCodiceISBN(), libro1);
//        archivio.put(libro2.getCodiceISBN(), libro2);
//        archivio.put(libro3.getCodiceISBN(), libro3);
//        archivio.put(libro4.getCodiceISBN(), libro4);
//        archivio.put(libro5.getCodiceISBN(), libro5);
//        archivio.put(libro6.getCodiceISBN(), libro6);
//        archivio.put(rivista1.getCodiceISBN(), rivista1);
//        archivio.put(rivista2.getCodiceISBN(), rivista2);
//        archivio.put(rivista3.getCodiceISBN(), rivista3);
//        archivio.put(rivista4.getCodiceISBN(), rivista4);
//        archivio.put(rivista5.getCodiceISBN(), rivista5);
//        archivio.put(rivista6.getCodiceISBN(), rivista6);


        // ESTRAZIONE DA FILE
        try {
            String fileContent = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] recordStrings = fileContent.split("#");

            for (String recordString : recordStrings) {
                String[] attributi = recordString.split("@");

                long codiceISBN = Long.parseLong(attributi[0]);
                String titolo = attributi[1];
                int numPagine = Integer.parseInt(attributi[2]);
                int anno = Integer.parseInt(attributi[3]);

                if (attributi.length == 6) { // Se ha 6 attributi, è un libro
                    String autore = attributi[4];
                    String genere = attributi[5];

                    Libro nuovoLibro = new Libro(codiceISBN, titolo, numPagine, anno, autore, genere);
                    archivio.put(codiceISBN, nuovoLibro);
                } else if (attributi.length == 5) { // Se ha 5 attributi, è una rivista
                    String periodicitaString = attributi[4];
                    Periodicita periodicita = Periodicita.valueOf(periodicitaString);
                    Rivista nuovaRivista = new Rivista(codiceISBN, titolo, numPagine, anno, periodicita);
                    archivio.put(codiceISBN, nuovaRivista);
                }
            }

            System.out.println("Numero totale di Pubblicazioni in archivio: " + archivio.size());
            System.out.println();
            archivio.forEach((isbn, pubblicazione) -> {
                System.out.println(pubblicazione);
            });

        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
        System.out.println();


        System.out.println("****METODI RICHIESTI PER IL PROGETTO****");
        System.out.println();

        //METODO PER L'AGGIUNTA DI PUBBLICAZIONI IN ARCHIVIO
        Pubblicazione rivistaDaAggiungere = new Rivista(9772037113003L, "The Economist", 96, 2024, Periodicita.SETTIMANALE);
        aggiungiRecord(archivio, rivistaDaAggiungere);
        System.out.println();

        //METODO PER ELIMINAZIONE DI PUBBLICAZIONI IN ARCHIVIO
        long queryEliminazione = 9772037113003L; //simulo una query che arriva, per eliminare il record (elimino lo stesso che ho aggiunto sopra)
        eliminaRecord(archivio, queryEliminazione);
        System.out.println();

        //METODO PER LA RICERCA TRAMITE CODICE ISBN
        long queryRicercaISBN = 9788820360420L;
        long querySbagliata = 55465656545L;
        cercaRecordPerISBN(archivio, queryRicercaISBN);
        cercaRecordPerISBN(archivio, querySbagliata);
        System.out.println();

        //METODO PER LA RICERCA PER ANNO
        int queryAnno = 2024;
        int queryAnno2 = 1954;
        ricercaPerAnno(archivio, queryAnno);
        ricercaPerAnno(archivio, queryAnno2);
        System.out.println();

        //METODO PER LA RICERCA PER AUTORE
        String queryAutore = "Row";
        String queryAutore2 = "rt";
        ricercaPerAutore(archivio, queryAutore);
        ricercaPerAutore(archivio, queryAutore2);
        System.out.println();


    }

    public static void aggiungiRecord(Map<Long, Pubblicazione> archivio, Pubblicazione pubblicazione) {
        if (archivio.containsKey(pubblicazione.getCodiceISBN())) {
            System.out.println("Record già presente nell'archivio.");
        } else {
            archivio.put(pubblicazione.getCodiceISBN(), pubblicazione);
            System.out.println("Record aggiunto con successo all'archivio.");
        }
    }

    public static void eliminaRecord(Map<Long, Pubblicazione> archivio, long ISBN) {
        Pubblicazione pubblicazioneRimossa = archivio.remove(ISBN);
        if (pubblicazioneRimossa == null) {
            System.out.println("Elemento non presente in archivio");
        } else {
            System.out.println("Record eliminato: " + pubblicazioneRimossa);
        }
    }

    public static void cercaRecordPerISBN(Map<Long, Pubblicazione> archivio, long ISBN) {
        Pubblicazione pubblicazioneCercata = archivio.get(ISBN);
        if (pubblicazioneCercata == null) {
            System.out.println("Elemento non presente in archivio");
        } else {
            System.out.println("Record trovato: " + pubblicazioneCercata);
        }
    }

    public static void ricercaPerAnno(Map<Long, Pubblicazione> archivio, int anno) {
        System.out.println("Risultati ricerca per anno: ");
        archivio.values()
                .stream()
                .filter(p -> p.getAnno() == anno)
                .forEach(System.out::println);
    }

    public static void ricercaPerAutore(Map<Long, Pubblicazione> archivio, String nome) {
        System.out.println("Risultati ricerca per autore: ");
        archivio.values()
                .stream()
                .filter(p -> p instanceof Libro)
                .filter(p -> ((Libro) p).getAutore().contains(nome))
                .forEach(System.out::println);

    }
}
