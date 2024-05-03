package catalogoBibliotecario.dao;

import catalogoBibliotecario.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getById(int id){
        return em.find(Utente.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Utente utente = getById(id);

        if(utente!=null){
            em.remove(utente);
        }
        else{
            System.out.println("Utente non presente");
        }

        et.commit();

    }
}
