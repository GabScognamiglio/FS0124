package es2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UsaConsumi {
    public static void main(String[] args) throws LitriException {
        Logger logger = LoggerFactory.getLogger("logger1");
        Scanner scanner = new Scanner(System.in);
        int x = 0;

        while (x < 10) {  //ripetuto 10 volte ai fini dell'esercizio
            CalcolaConsumi calcolaConsumi = new CalcolaConsumi();
            try {
                System.out.println("Qaunti Km hai percorso?");
                int km = scanner.nextInt();
                System.out.println("Quanti litri hai consumato?");
                int litri = scanner.nextInt();
                if (litri == 0) {
                    throw new LitriException("Non puoi aver consumato 0 litri");
                }
                System.out.println("Il consumo in km/l è di: " + calcolaConsumi.KmAlLitro(km, litri));

            } catch (LitriException e) {
                logger.info(e.getMessage());
            }
            x++;
        }
    }
}
