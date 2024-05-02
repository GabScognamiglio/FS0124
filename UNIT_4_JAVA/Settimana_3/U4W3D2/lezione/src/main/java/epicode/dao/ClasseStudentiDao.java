package epicode.dao;

import epicode.entity.ClasseStudenti;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClasseStudentiDao {

    private EntityManager em;

    public ClasseStudentiDao(EntityManager em){
        this.em=em;
    }

    public void save(ClasseStudenti classeStudenti) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(classeStudenti);
        et.commit();
    }

    public ClasseStudenti getById(int id){
        return em.find(ClasseStudenti.class, id);
    }

    public void delete(ClasseStudenti classeStudenti) {
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.remove(classeStudenti);
        et.commit();
    }
}
