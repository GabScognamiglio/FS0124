package player;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile{
    private int volume;
    private int durata;

    public RegistrazioneAudio(String titolo, int durata) {
        super(titolo);
        this.durata = Math.max(durata, 0);
        this.volume = 5; //valore di partenza del volume, altrimenti partono tutti 'muti'

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
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.getTitolo()+esclamativi);
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

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
