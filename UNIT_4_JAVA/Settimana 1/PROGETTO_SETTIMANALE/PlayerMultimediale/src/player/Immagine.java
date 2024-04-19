package player;

public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = Math.max(luminosita, 0);
    }

    @Override
    public void riproduci() {
        this.show();
    }

    public void show() {
        StringBuilder asterischi = new StringBuilder();
        for (int i = 0; i < this.luminosita; i++) {
            asterischi.append("*");
        }
        System.out.println(this.getTitolo() + asterischi);
    }
}
