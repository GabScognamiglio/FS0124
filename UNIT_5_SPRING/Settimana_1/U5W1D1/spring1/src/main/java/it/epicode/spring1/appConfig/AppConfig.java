package it.epicode.spring1.appConfig;

import it.epicode.spring1.bean.Aula;
import it.epicode.spring1.bean.Computer;
import it.epicode.spring1.bean.Smartphone;
import it.epicode.spring1.bean.Studente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean("Gab")
    public Studente getStudente () {
        Studente studente = new Studente();
        studente.setNome("Gab");
        studente.setCognome("Sco");
        studente.setIndirizzo("Via Roma 16");
        studente.setDisposiivi(List.of(getComputer(), getSmartphone()));
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

    @Bean
    public Computer getComputer () {
        Computer computer =  new Computer();
        computer.setCpu("Intel I7");
        computer.setRam(32);
        computer.setNome("Pavillon");
        computer.setMarca("HP");
        computer.setMonitor(27);

        return computer;
    }

    @Bean
    public Smartphone getSmartphone () {
        Smartphone smartphone = new Smartphone();
        smartphone.setSchermo(6);
        smartphone.setMarca("Samsung");
        smartphone.setNome("Galaxy S24");

        return smartphone;
    }

    @Bean
    public Aula getAula(){
        Aula aula = new Aula();
        aula.setNome("A1");
        aula.setStudenti(List.of(getStudente(), getStudente2()));

        return aula;
    }
}
