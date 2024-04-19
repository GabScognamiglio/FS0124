import player.ElementoMultimediale;
import player.Immagine;
import player.RegistrazioneAudio;
import player.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ElementoMultimediale[] lista = new ElementoMultimediale[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println((i+1) + "/5 - Scegli il tipo (1.Audio, 2.Video, 3.Immagine): ");
            int sceltaTipo = scanner.nextInt();
            scanner.nextLine();

            switch (sceltaTipo) {
                case 1:

                    System.out.println("Inserisci il titolo");
                    String titoloAudio = scanner.nextLine();
                    System.out.println("Inserisci la durata");
                    int durataAudio = scanner.nextInt();
                    ElementoMultimediale elementoAudio = new RegistrazioneAudio(titoloAudio, durataAudio);
                    lista[i] = elementoAudio;
                    break;

                case 2:

                    System.out.println("Inserisci il titolo");
                    String titoloVideo = scanner.nextLine();
                    System.out.println("Inserisci la durata");
                    int durataVideo = scanner.nextInt();
                    System.out.println("Inserisci la luminosità");
                    int luminositaVideo = scanner.nextInt();
                    ElementoMultimediale elementoVideo = new Video(titoloVideo, durataVideo, luminositaVideo);
                    lista[i] = elementoVideo;
                    break;

                case 3:

                    System.out.println("Inserisci il titolo");
                    String titoloImmagine = scanner.nextLine();
                    System.out.println("Inserisci la luminosità");
                    int luminositaImmagine = scanner.nextInt();
                    ElementoMultimediale elementoImmagine = new Immagine(titoloImmagine, luminositaImmagine);
                    lista[i] = elementoImmagine;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    i--;
                    break;

            }
        }

        int riproduzione = 0;

        do {
            System.out.println("Scegli un elemento multimediale da 1 a 5, 0 per chiudere");
            riproduzione = scanner.nextInt();
            scanner.nextLine();
            if (riproduzione > 5) {
                System.out.println("scegli un valore tra 1 e 5, e 0 per chiudere");
                riproduzione = scanner.nextInt();
                scanner.nextLine();
            }
            if (riproduzione != 0 && riproduzione<6) {
                lista[riproduzione - 1].riproduci();
            }
        }
        while (riproduzione > 0 && riproduzione <= 5);
    }
}