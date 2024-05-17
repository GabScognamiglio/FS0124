package it.epicode.gestione_prenotazioni;

import it.epicode.gestione_prenotazioni.bean.Edificio;
import it.epicode.gestione_prenotazioni.bean.Postazione;
import it.epicode.gestione_prenotazioni.bean.Prenotazione;
import it.epicode.gestione_prenotazioni.bean.Utente;
import it.epicode.gestione_prenotazioni.bean.enums.TipoPostazione;
import it.epicode.gestione_prenotazioni.service.EdificioService;
import it.epicode.gestione_prenotazioni.service.PostazioneService;
import it.epicode.gestione_prenotazioni.service.PrenotazioneService;
import it.epicode.gestione_prenotazioni.service.UtenteService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {

    @Autowired
    UtenteService utenteService;

    @Autowired
    EdificioService edificioService;

    @Autowired
    PostazioneService postazioneService;

    @Autowired
    PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

//       utenteService.salvaUtente(ctx.getBean("gabriele", Utente.class));
//        utenteService.salvaUtente(ctx.getBean("martina", Utente.class));
//        utenteService.salvaUtente(ctx.getBean("alessandro", Utente.class));
//
//        edificioService.salvaEdificio(ctx.getBean("edificio1", Edificio.class));
//        edificioService.salvaEdificio(ctx.getBean("edificio2", Edificio.class));
//        edificioService.salvaEdificio(ctx.getBean("edificio3", Edificio.class));

//        Postazione post1 = ctx.getBean("postazione1", Postazione.class);
//        post1.setEdificio(edificioService.getEdificioById(1));
//        postazioneService.salvaPostazione(post1);
//        Postazione post2 = ctx.getBean("postazione2", Postazione.class);
//        post2.setEdificio(edificioService.getEdificioById(1));
//        postazioneService.salvaPostazione(post2);
//        Postazione post3 = ctx.getBean("postazione3", Postazione.class);
//        post3.setEdificio(edificioService.getEdificioById(2));
//        postazioneService.salvaPostazione(post3);


//          ******* TEST SULLE PERSISTENZE DELLE PRENOTAZIONI *******

//        Prenotazione pren1 = new Prenotazione();
//        pren1.setDataPrenotazione(LocalDate.now());
//        pren1.setUtente(utenteService.getUtenteById(1));
//        pren1.setPostazione(postazioneService.getPostazioneById(1));
//
//        prenotazioneService.salvaPrenotazione(pren1);


        //LA SEGUENTE DA' ERRORE PERCHÈ L'UTENTE CON ID 1 HA GIA' UNA PRENOTAZIONE NELLA DATA DI OGGI (vedi righe 61-65)
//        Prenotazione pren2 = new Prenotazione();
//        pren2.setDataPrenotazione(LocalDate.now());
//        pren2.setUtente(utenteService.getUtenteById(1));
//        pren2.setPostazione(postazioneService.getPostazioneById(2));
//
//        prenotazioneService.salvaPrenotazione(pren2);

        //MENTRE QUESTA FUNZIONA PERCHÈ L'UTENTE È LO STESSO, MA LA DATA DIVERSA
//        Prenotazione pren3 = new Prenotazione();
//        pren3.setDataPrenotazione(LocalDate.of(2024,5,20));
//        pren3.setUtente(utenteService.getUtenteById(1));
//        pren3.setPostazione(postazioneService.getPostazioneById(3));
//
//        prenotazioneService.salvaPrenotazione(pren3);

        //QUESTA DI NUOVO NON FUNZIONA PERCHÈ ESISTE GIA' UNA PRENOTAZIONE IN DATA ODIERNA NELLA POSTAZIONE CON ID 1 (vedi ancora righe 61-65)
//        Prenotazione pren4 = new Prenotazione();
//        pren4.setDataPrenotazione(LocalDate.now());
//        pren4.setUtente(utenteService.getUtenteById(2));
//        pren4.setPostazione(postazioneService.getPostazioneById(1));
//
//        prenotazioneService.salvaPrenotazione(pren4);


        //RICERCA DI POSTAZIONI IN BASE AL TIPO (metodo definito in PostazioneService.java)
        System.out.println("RICERCA POSTAZIONI PER TIPO");
        postazioneService.cercaPostazioniPerTipo(TipoPostazione.SALA_RIUNIONI).forEach(System.out::println);
        System.out.println();

        //RICERCA DI POSTAZIONI DATA UNA CITTA
        System.out.println("RICERCA POSTAZIONI PER CITTA' DELL'EDIFICIO IN CUI SI TROVANO");
        postazioneService.cercaPostazioniPerCitta("Roma").forEach(System.out::println);
        System.out.println();

        //RICERCA DI POSTAZIONI PER CITTA E TIPO
        System.out.println("RICERCA POSTAZIONI PER TIPO E CITTA' DELL'EDIFICIO IN CUI SI TROVANO");
        postazioneService.cercaPostazioniPerTipoECitta(TipoPostazione.SALA_RIUNIONI, "Milano").forEach(System.out::println);
        System.out.println();
    }
}
