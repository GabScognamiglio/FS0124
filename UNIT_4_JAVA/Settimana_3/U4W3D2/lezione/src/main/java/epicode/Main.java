package epicode;


import epicode.dao.ClasseStudentiDao;
import epicode.dao.CorsoDao;
import epicode.dao.IndirizzoDao;
import epicode.dao.StudenteDao;
import epicode.entity.ClasseStudenti;
import epicode.entity.Corso;
import epicode.entity.Indirizzo;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        IndirizzoDao indirizzoDao = new IndirizzoDao(em);
        StudenteDao studenteDao = new StudenteDao(em);
        ClasseStudentiDao classeStudentiDao = new ClasseStudentiDao(em);
        CorsoDao corsoDao = new CorsoDao(em);
//        Studente s1 = new Studente();
//        s1.setNome("Francesco");
//        s1.setCognome("Totti");
//        s1.setDataNascita(LocalDate.of(1976, 9, 27));
//
//
//        Studente s3 = new Studente();
//        s3.setNome("Gabriele");
//        s3.setCognome("Scognamiglio");
//        s3.setDataNascita(LocalDate.of(1995, 2, 16));

//        studenteDao.save(s1);
//        studenteDao.save(s3);  //metodo per salvare su db

//        Studente sx = studenteDao.getById(11);
//        studenteDao.delete(sx);

//        Studente s11 = new Studente();
//        s11.setNome("Fabio");
//        s11.setDataNascita(LocalDate.of(1995, 12, 31));
//        s11.setCognome("Pasfadini");
//
//        Indirizzo indirizzo = new Indirizzo();
//        indirizzo.setVia("Via Roma 16");
//        indirizzo.setComune("Fiumicino");
//        indirizzo.setProvincia("Roma");
//
//        ClasseStudenti classeStudenti = new ClasseStudenti();
//        classeStudenti.setNome("Matematica");
//        classeStudenti.setPiano(3);
//
//        Studente s22 = new Studente();
//        s22.setNome("Mario");
//        s22.setDataNascita(LocalDate.of(1990, 2, 1));
//        s22.setCognome("Cisafrulli");
//        s22.setClasseStudenti(classeStudenti);
//
//
//        s11.setClasseStudenti(classeStudenti);
//        s11.setIndirizzo(indirizzo);
//
//
//       classeStudentiDao.save(classeStudenti);
//        indirizzoDao.save(indirizzo);
//        studenteDao.save(s11);
//        studenteDao.save(s22);

        Corso corso1 = new Corso();
        corso1.setNome("Java");

        Corso corso2= new Corso();
        corso2.setNome("Hibernate");

        corsoDao.save(corso1);
        corsoDao.save(corso2);

        Studente studenteX = studenteDao.getById(28);
        Studente studenteY = studenteDao.getById(29);

        studenteX.setCorsi(List.of(corso1,corso2));
        studenteY.setCorsi(List.of(corso1,corso2));

        studenteDao.save(studenteX);
        studenteDao.save(studenteY);







    }
}
