package epicode.dao;


import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudenteDao {
    private EntityManager em;

    public StudenteDao(EntityManager em){
        this.em=em;
    }

    public void save(Studente studente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(studente);
        et.commit();
    }

    public Studente getById(int matricola){
        return em.find(Studente.class, matricola);
    }

    public void delete(Studente studente) {
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.remove(studente);
        et.commit();
    }
}
