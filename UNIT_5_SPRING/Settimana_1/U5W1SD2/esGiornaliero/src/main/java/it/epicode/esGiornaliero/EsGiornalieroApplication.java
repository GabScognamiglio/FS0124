package it.epicode.esGiornaliero;

import it.epicode.esGiornaliero.appConfig.AppConfig;
import it.epicode.esGiornaliero.bean.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EsGiornalieroApplication {
	public static void main(String[] args) {
		SpringApplication.run(EsGiornalieroApplication.class, args);
	}

}
