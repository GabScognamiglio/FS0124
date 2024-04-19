package player;

public class Video extends ElementoMultimediale implements Riproducibile {
    private int volume;
    private int durata;
    private int luminosita;

    public Video(String titolo, int durata, int luminosita) {
        super(titolo);
        this.durata = Math.max(durata, 0);
        this.volume = 5; //valore di partenza del volume, altrimenti partono tutti 'muti';
        this.luminosita = Math.max(luminosita, 0);
    }

    @Override
    public void riproduci() {
        this.play();
    }

    @Override
    public void play(){
        StringBuilder esclamativi = new StringBuilder();
        for (int i = 0; i < this.volume; i++) {
            esclamativi.append("!");
        }

        StringBuilder asterischi = new StringBuilder();
        for (int i = 0; i < this.luminosita; i++) {
            asterischi.append("*");
        }

        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.getTitolo()+esclamativi+asterischi);
        }
    }

    public void abbassaVolume(){
        if (volume>0){
            volume--;
        }
        return;
    }

    public void alzaVolume(){
        volume++;
    }

    public void diminuisciLuminosita(){
        if (luminosita>0){
            luminosita--;
        }
        return;
    }

    public void aumentaLuminosita(){
        luminosita++;
    }
}
