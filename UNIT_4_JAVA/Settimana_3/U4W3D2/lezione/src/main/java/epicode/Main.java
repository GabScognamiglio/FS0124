package epicode;


import epicode.dao.StudenteDao;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao dao = new StudenteDao(em);
        Studente s1 = new Studente();
        s1.setNome("Francesco");
        s1.setCognome("Totti");
        s1.setDataNascita(LocalDate.of(1976, 9, 27));
        s1.setIndirizzo("Via di Porta Metronia");

        Studente s3 = new Studente();
        s3.setNome("Gabriele");
        s3.setCognome("Scognamiglio");
        s3.setDataNascita(LocalDate.of(1995, 2, 16));
        s3.setIndirizzo("Via di Calabria, 64");

//        dao.save(s1);
//        dao.save(s3);  //metodo per salvare su db

//        Studente sx = dao.getById(11);
//        dao.delete(sx);
    }
}
