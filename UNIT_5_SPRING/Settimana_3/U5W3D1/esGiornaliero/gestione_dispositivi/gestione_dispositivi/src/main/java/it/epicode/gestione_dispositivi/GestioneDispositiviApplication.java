package it.epicode.gestione_dispositivi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
public class GestioneDispositiviApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneDispositiviApplication.class, args);
	}

}
