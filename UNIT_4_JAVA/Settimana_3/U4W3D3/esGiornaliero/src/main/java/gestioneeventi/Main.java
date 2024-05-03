package gestioneeventi;

import gestioneeventi.dao.EventoDao;
import gestioneeventi.dao.LocationDao;
import gestioneeventi.dao.PartecipazioneDao;
import gestioneeventi.dao.PersonaDao;
import gestioneeventi.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi_pt2");
//        EntityManager em = emf.createEntityManager();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi2");
        EntityManager em = emf.createEntityManager();

        EventoDao eventoDao = new EventoDao(em);
        LocationDao locationDao = new LocationDao(em);
        PersonaDao personaDao = new PersonaDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);

        Location l1 = new Location("Villa Cianfrani", "Fiumicino");

        Evento ev1 = new Evento();
        ev1.setTitolo("Concerto Metallica");
        ev1.setDataEvento(LocalDate.of(2024,8,4));
        ev1.setTipoEvento(TipoEVento.PUBBLICO);
        ev1.setNumMaxPartecipanti(1000000);
        ev1.setLocation(l1);

        Persona p1 = new Persona();
        p1.setNome("Gabriele");
        p1.setCognome("Scognamiglio");
        p1.setDataNascita(LocalDate.of(1995,2,16));
        p1.setEmail("gab@sco.it");
        p1.setSesso(Sesso.M);

        Partecipazione part1 = new Partecipazione(p1,ev1,Stato.CONFERMATA);

        locationDao.save(l1);
        eventoDao.save(ev1);
        personaDao.save(p1);
        partecipazioneDao.save(part1);


//        //cerco una persona e stampo  le partecipazioni
//        Persona persona = em.find(Persona.class, 15);
//            List<Partecipazione> partecipazioni = persona.getListaPartecipazioni();
//            for (Partecipazione partecipazione : partecipazioni) {
//                System.out.println(partecipazione);
//            }

    }
}
