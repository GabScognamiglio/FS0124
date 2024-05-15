package it.epicode.esGiornaliero;

import it.epicode.esGiornaliero.bean.Menu;
import it.epicode.esGiornaliero.bean.Tavolo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class EsGiornalieroApplicationTests {

	static ApplicationContext ctx;

	@BeforeAll
	public static void accediAlContesto(){
		ctx = new AnnotationConfigApplicationContext(EsGiornalieroApplication.class);
		System.out.println("Accesso al contesto avvenuto");
	}

	@Test
	void verificaStatoTavolo(){
		Tavolo tavolo = ctx.getBean(Tavolo.class);
		Assertions.assertEquals(1, tavolo.getNumTavolo());
	}

	@ParameterizedTest //test parametrizzato, che viene ripetuto tante volte quante sono le stringhe nell'array
	@ValueSource(strings = {"S","M"})
	void pizzeCheHannoNomeCheIniziaCon(String iniziale){
		Menu menu = ctx.getBean(Menu.class);
		menu.getPizze().stream().filter(p->p.getNome().startsWith(iniziale)).forEach(System.out::println);
		long numPizze = menu.getPizze().stream().filter(p->p.getNome().startsWith(iniziale)).count();
		Assertions.assertEquals(1,numPizze);
	}

	@AfterAll
	public static void chiudiContesto(){
		ctx=null;
		System.out.println("Contesto chiuso");
	}

}
