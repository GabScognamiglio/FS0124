package gestioneeventi;

import gestioneeventi.dao.EventoDao;
import gestioneeventi.entity.Evento;
import gestioneeventi.entity.TipoEVento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");
        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

//        Evento ev1 = new Evento();
//        ev1.setTitolo("Festa Gab");
//        ev1.setDataEvento(LocalDate.of(2024,5,6));
//        ev1.setTipoEvento(TipoEVento.PRIVATO);
//        ev1.setNumMaxPartecipanti(1000);
//
//        dao.save(ev1);

        dao.delete(dao.getById(1));
    }
}
