package es3;

public class Banca {
    public static void main(String args[]) {
        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        try {
            conto1.preleva(1750.5);

            System.out.println("Saldo conto: " + conto1.restituisciSaldo());
        } catch (BancaException e) {
            System.out.println("Errore durante il prelievo: " + e);
            e.printStackTrace();
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
            System.out.println("Errore durante il prelievo: " + e.getMessage() + " -- num mov:" + conto2.nMovimenti );
//            e.printStackTrace();
        }
    }
}
