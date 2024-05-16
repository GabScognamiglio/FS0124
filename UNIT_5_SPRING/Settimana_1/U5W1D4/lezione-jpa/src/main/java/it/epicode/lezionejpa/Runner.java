package it.epicode.lezionejpa;


import it.epicode.lezionejpa.bean.Pizza;
import it.epicode.lezionejpa.service.CibiMenuService;
import it.epicode.lezionejpa.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LezioneJpaApplication.class);

    }
}