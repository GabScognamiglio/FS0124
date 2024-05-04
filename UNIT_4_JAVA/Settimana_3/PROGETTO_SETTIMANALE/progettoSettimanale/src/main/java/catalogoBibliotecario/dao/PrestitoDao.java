package catalogoBibliotecario.dao;

import catalogoBibliotecario.entity.Prestito;
import catalogoBibliotecario.entity.Pubblicazione;
import catalogoBibliotecario.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

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

    public List<Pubblicazione> elementiInPrestitoAttualmente(int numeroTessera) {
        Query query = em.createQuery("SELECT p.elementoPrestato from Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzione IS NULL");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> prestitiScadutiNonRestituiti(){
        Query query = em.createQuery("SELECT p from Prestito p WHERE p.dataFinePrestito < :dataOdierna AND p.dataRestituzione IS NULL");
        query.setParameter("dataOdierna", LocalDate.now());
        return query.getResultList();
    }
}
