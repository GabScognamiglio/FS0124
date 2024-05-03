package catalogoBibliotecario.dao;

import catalogoBibliotecario.entity.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDao {
    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id){
        return em.find(Prestito.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prestito prestito = getById(id);

        if(prestito!=null){
            em.remove(prestito);
        }
        else{
            System.out.println("Prestito non presente");
        }

        et.commit();

    }
}
