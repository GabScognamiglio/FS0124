import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger logger = LoggerFactory.getLogger("logger1");

    public static void main(String[] args) {
        logger.warn("sto lanaciando l'app");  //log iniziale   // trace debug info warn error


        System.out.println("Hello world!"); //app


        logger.info("sto terminando l'app");  //log finale
    }

}