package it.epicode.esGiornaliero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class EsGiornalieroApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsGiornalieroApplication.class, args);
    }

}
