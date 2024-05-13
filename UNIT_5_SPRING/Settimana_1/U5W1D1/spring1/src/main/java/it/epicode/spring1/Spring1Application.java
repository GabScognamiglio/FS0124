package it.epicode.spring1;

import it.epicode.spring1.appConfig.AppConfig;
import it.epicode.spring1.bean.Aula;
import it.epicode.spring1.bean.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Studente studente = ctx.getBean("Gab", Studente.class);
		Studente studente2 = ctx.getBean("Mario", Studente.class);

		System.out.println(studente);
		System.out.println(studente2);

		Aula aula = ctx.getBean(Aula.class);
		System.out.println(aula);

//		Map<String, Studente> listaStud = ctx.getBeansOfType(Studente.class);
//		listaStud.forEach((a, b)-> System.out.println(a + b));
	}

}
