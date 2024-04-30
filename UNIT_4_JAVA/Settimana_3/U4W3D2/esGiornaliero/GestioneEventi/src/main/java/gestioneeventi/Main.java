package gestioneeventi;

import gestioneeventi.dao.EventoDao;
import gestioneeventi.entity.Evento;
import gestioneeventi.entity.TipoEVento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");
        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

//        Evento ev1 = new Evento();
//        ev1.setTitolo("Concerto Metallica");
//        ev1.setDataEvento(LocalDate.of(2024,8,4));
//        ev1.setTipoEvento(TipoEVento.PUBBLICO);
//        ev1.setNumMaxPartecipanti(1000000);
//
//        dao.save(ev1);

//        dao.delete(dao.getById(3));

        Query query = em.createQuery("SELECT e FROM Evento e");

        List<Evento> eventi = query.getResultList();
        for (Evento ev : eventi) {
            System.out.println(ev); // Stampa l'oggetto Persona (assumendo che abbia un metodo toString() adeguato)
        }
        em.close();
        emf.close();
    }
}
