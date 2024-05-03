package catalogoBibliotecario.dao;

import catalogoBibliotecario.entity.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PubblicazioneDao {
    private EntityManager em;

    public PubblicazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Pubblicazione pubblicazione){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(pubblicazione);
        et.commit();
    }

    public Pubblicazione getById(int id){
        return em.find(Pubblicazione.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Pubblicazione pubblicazione = getById(id);

        if(pubblicazione!=null){
            em.remove(pubblicazione);
        }
        else{
            System.out.println("Pubblicazione non presente");
        }

        et.commit();

    }
}
