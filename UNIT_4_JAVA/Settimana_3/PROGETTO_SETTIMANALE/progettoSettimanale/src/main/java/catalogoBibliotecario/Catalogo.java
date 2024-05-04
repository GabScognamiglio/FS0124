package catalogoBibliotecario;

import catalogoBibliotecario.dao.PrestitoDao;
import catalogoBibliotecario.dao.PubblicazioneDao;
import catalogoBibliotecario.dao.UtenteDao;
import catalogoBibliotecario.entity.Libro;
import catalogoBibliotecario.entity.Prestito;
import catalogoBibliotecario.entity.Rivista;
import catalogoBibliotecario.entity.enums.Periodicita;
import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.UUID;

public class Catalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_bibliotecario");
        EntityManager em = emf.createEntityManager();

        PubblicazioneDao pubblicazioneDao = new PubblicazioneDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);

//        Libro l1 = new Libro();
//        l1.setTitle("qwerty");
//        l1.setNumPagine(300);
//        l1.setAnno(2022);
//        l1.setAutore("Franco Granchio");
//        l1.setGenere("Horror");
//
//        Libro l2 = new Libro();
//        l2.setTitle("Pappardelle");
//        l2.setNumPagine(180);
//        l2.setAnno(1985);
//        l2.setAutore("Mario Zurlì");
//        l2.setGenere("Cucina");
//
//
//        Rivista r1 = new Rivista();
//        r1.setTitle("GeoPop");
//        r1.setNumPagine(140);
//        r1.setAnno(2024);
//        r1.setPeriodicita(Periodicita.MENSILE);


        //1)**Metodo per aggiunta elementi (libri/riviste) al catalogo**
//        pubblicazioneDao.save(l1);
//        pubblicazioneDao.save(l2);
//        pubblicazioneDao.save(r1);

        //2)**Metodo per rimozione di un elemento dal catalogo dato un codice ISBN**
//        pubblicazioneDao.delete(UUID.fromString("0abe28b8-6778-41e5-81f9-d28bcf6d35ac"));

        //3)**Metodo per la ricerca per ISBN**
        System.out.println(pubblicazioneDao.cercaPerISBN(UUID.fromString("9ac6bea8-00c4-445c-a77a-de8b83e88615")));
        System.out.println();

        //4)**Metodo per la ricerca per anno pubblicazione**
        pubblicazioneDao.cercaPerAnno(1985).forEach(System.out::println);
        System.out.println();

        //5)**Metodo per la ricerca per autore (anche parziale)**
        pubblicazioneDao.cercaPerAutore("anco").forEach(System.out::println);
        System.out.println();

        //6)**Metodo per la ricerca per titolo o parte di esso**
        pubblicazioneDao.cercaPerTitolo("appa").forEach(System.out::println);
        System.out.println();

        //7)**Metodo per la ricerca di elementi attualmente in prestito dato un numero di tessera utente**
        System.out.println("Elementi in prestito all'utente 1002");
        prestitoDao.elementiInPrestitoAttualmente(1002).forEach(System.out::println);
        System.out.println();

        //8)**Metodo per la ricerca di tutti i prestiti scaduti e non ancora restituiti**
        prestitoDao.prestitiScadutiNonRestituiti().forEach(System.out::println);
        System.out.println();



    }
}
