package it.epicode.gestione_prenotazioni.appConfig;


import it.epicode.gestione_prenotazioni.bean.Edificio;
import it.epicode.gestione_prenotazioni.bean.Postazione;
import it.epicode.gestione_prenotazioni.bean.Utente;
import it.epicode.gestione_prenotazioni.bean.enums.TipoPostazione;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean("gabriele")
    public Utente utente1(){
        Utente utente = new Utente();
        utente.setNome("Gabriele");
        utente.setCognome("Scognamiglio");
        utente.setEmail("gab@sco.it");
        utente.setUsername("Gab16");

        return utente;
    }

    @Bean("alessandro")
    public Utente utente2() {
        Utente utente = new Utente();
        utente.setNome("Alessandro");
        utente.setCognome("Rossi");
        utente.setEmail("ale@rossi.it");
        utente.setUsername("Ale22");
        return utente;
    }

    @Bean("martina")
    public Utente utente3() {
        Utente utente = new Utente();
        utente.setNome("Martina");
        utente.setCognome("Bianchi");
        utente.setEmail("martina@bianchi.it");
        utente.setUsername("MartinaB");
        return utente;
    }

    @Bean("edificio1")
    public Edificio edificio1() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio A");
        edificio.setIndirizzo("Via Roma, 123");
        edificio.setCitta("Roma");
        return edificio;
    }

    @Bean("edificio2")
    public Edificio edificio2() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio B");
        edificio.setIndirizzo("Via Milano, 456");
        edificio.setCitta("Milano");
        return edificio;
    }

    @Bean("edificio3")
    public Edificio edificio3() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio C");
        edificio.setIndirizzo("Via Napoli, 789");
        edificio.setCitta("Napoli");
        return edificio;
    }

    @Bean("postazione1")
    public Postazione postazione1() {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione A");
        postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione.setNumMaxOccupanti(5);;
        return postazione;
    }

    @Bean("postazione2")
    public Postazione postazione2() {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione B");
        postazione.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione.setNumMaxOccupanti(2);
        return postazione;
    }

    @Bean("postazione3")
    public Postazione postazione3() {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione C");
        postazione.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazione.setNumMaxOccupanti(10);
        return postazione;
    }



}
