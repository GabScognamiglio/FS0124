package es3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Banca {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("logger1");
        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 1000);

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        try {
            conto1.preleva(1750.5);

            System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        } catch (BancaException e) {
            logger.error("Errore durante il prelievo: " + e);
            //System.out.println("Errore durante il prelievo: " + e);
            //e.printStackTrace();
        }

        ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 2000.0, 1500);

        conto2.stampaSaldo();

        try {
            conto2.preleva(1600);

            conto2.stampaSaldo();
            if(conto2.restituisciSaldo()<0){
                throw new BancaException();
            }

        } catch (BancaException e) {
            logger.error("Errore durante il prelievo: " + e.getMessage() + " -- num mov:" + conto2.nMovimenti );
//            System.out.println("Errore durante il prelievo: " + e.getMessage() + " -- num mov:" + conto2.nMovimenti );
//            e.printStackTrace();
        }
    }
}
