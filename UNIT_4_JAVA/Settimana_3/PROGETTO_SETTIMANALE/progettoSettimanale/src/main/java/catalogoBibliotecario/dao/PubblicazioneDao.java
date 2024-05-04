package catalogoBibliotecario.dao;

import catalogoBibliotecario.entity.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class PubblicazioneDao {
    private EntityManager em;

    public PubblicazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Pubblicazione pubblicazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(pubblicazione);
        et.commit();
    }

    public Pubblicazione getById(UUID codiceISBN) {
        return em.find(Pubblicazione.class, codiceISBN);
    }

    public void delete(UUID codiceISBN) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Pubblicazione pubblicazione = getById(codiceISBN);

        if (pubblicazione != null) {
            em.remove(pubblicazione);
        } else {
            System.out.println("Pubblicazione non presente");
        }

        et.commit();

    }

    public Pubblicazione cercaPerISBN(UUID codiceISBN) {
        return em.createQuery(
                        "SELECT p FROM Pubblicazione p WHERE p.codiceISBN = :codiceISBN", Pubblicazione.class)
                .setParameter("codiceISBN", codiceISBN)
                .getSingleResult();
    }

    public List<Pubblicazione> cercaPerAnno(int anno) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.anno = :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Pubblicazione> cercaPerAutore(String autore) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.autore LIKE :autore");
        query.setParameter("autore", "%" + autore + "%");
        return query.getResultList();
    }

    public List<Pubblicazione> cercaPerTitolo(String title) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.title LIKE :title");
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }
}
