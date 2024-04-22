package es1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) throws IndiceException {
        Logger logger = LoggerFactory.getLogger("logger1");

        int[] numeri = new int[5];
        Random random = new Random();
        numeri[0] = random.nextInt(11);
        numeri[1] = random.nextInt(11);
        numeri[2] = random.nextInt(11);
        numeri[3] = random.nextInt(11);
        numeri[4] = random.nextInt(11);

        System.out.println(numeri[0] + " " + numeri[1] + " " + numeri[2] + " " + numeri[3] + " " + numeri[4]);

        Scanner scanner = new Scanner(System.in);
        int indice;
        int valore;

        while (true) {
            try {
                System.out.print("Inserire la posizione (0-4) e il valore da inserire (0 per terminare): ");
                indice = scanner.nextInt();

                if (indice == 0) {
                    break;
                }

                if (indice < 0 || indice >= numeri.length) {
                    throw new IndiceException("Posizione non valida. Inserire una posizione compresa tra 0 e 4.");
                }
                System.out.print("Inserire un valore:");
                valore = scanner.nextInt();
                if (valore < 1 || valore > 10) {
                    throw new IndiceException("Valore non valido. Inserire un numero compreso tra 1 e 10.");
                }

                numeri[indice] = valore;
                System.out.println("Nuovo stato dell'array:");
                System.out.println(numeri[0] + " " + numeri[1] + " " + numeri[2] + " " + numeri[3] + " " + numeri[4]);
            } catch (IndiceException e) {
                logger.error("Errore: " + e.getMessage());

            }
        }

    }
}

