package gestioneeventi.dao;

import gestioneeventi.entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {
    private EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
    }

    public Evento getById(int id){
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }
}
