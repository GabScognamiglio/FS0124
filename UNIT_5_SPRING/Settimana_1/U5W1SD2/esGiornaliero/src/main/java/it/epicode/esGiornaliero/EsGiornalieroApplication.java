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

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println();
		System.out.println("***   MENU'   ***");
		System.out.println();

		Menu menu = ctx.getBean(Menu.class);

		menu.getPizze().forEach(System.out::println);
		System.out.println();
		menu.getIngredienti().forEach(System.out::println);
		System.out.println();
		menu.getBevande().forEach(System.out::println);
		System.out.println();


	}

}
