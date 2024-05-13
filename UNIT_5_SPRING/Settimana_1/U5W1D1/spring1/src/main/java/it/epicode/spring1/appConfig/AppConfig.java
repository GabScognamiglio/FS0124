package it.epicode.spring1.appConfig;

import it.epicode.spring1.bean.Studente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("Gab")
    public Studente getStudente () {
        Studente studente = new Studente();
        studente.setNome("Gab");
        studente.setCognome("Sco");
        studente.setIndirizzo("Via Roma 16");

        return studente;
    }

    @Bean("Mario")
    public Studente getStudente2 () {
        Studente studente = new Studente();
        studente.setNome("Mario");
        studente.setCognome("Franzalli");
        studente.setIndirizzo("Via Milano 6");

        return studente;
    }
}
