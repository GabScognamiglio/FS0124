package epicode.dao;

import epicode.entity.Indirizzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class IndirizzoDao {
    private EntityManager em;

    public IndirizzoDao(EntityManager em){
        this.em=em;
    }

    public void save(Indirizzo indirizzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(indirizzo);
        et.commit();
    }

    public Indirizzo getById(int id){
        return em.find(Indirizzo.class, id);
    }

    public void delete(Indirizzo indirizzo) {
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.remove(indirizzo);
        et.commit();
    }
}
