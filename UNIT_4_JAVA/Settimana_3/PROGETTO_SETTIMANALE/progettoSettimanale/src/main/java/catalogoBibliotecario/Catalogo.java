package catalogoBibliotecario;

import catalogoBibliotecario.dao.PrestitoDao;
import catalogoBibliotecario.dao.PubblicazioneDao;
import catalogoBibliotecario.dao.UtenteDao;
import catalogoBibliotecario.entity.Libro;
import catalogoBibliotecario.entity.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Catalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_bibliotecario");
        EntityManager em = emf.createEntityManager();

        PubblicazioneDao pubblicazioneDao = new PubblicazioneDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);

        Libro l1 = new Libro();
        l1.setTitle("qwerty");
        l1.setNumPagine(300);
        l1.setAnno(2022);
        l1.setAutore("Franco Granchio");
        l1.setGenere("Horror");


        //metodo per aggiunta elementi (libri/riviste) al catalogo
        pubblicazioneDao.save(l1);

    }
}
