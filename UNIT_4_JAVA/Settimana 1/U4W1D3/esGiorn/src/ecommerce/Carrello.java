package ecommerce;

public class Carrello {
    private Cliente cliente;
    private Articolo[] articoli;

    public Carrello(Cliente c) {
        this.cliente=c;
        this.articoli=new Articolo[0];
    }

    public int totaleCarrello(){
        int somma=0;
        for (Articolo articolo:this.articoli){
            somma+=articolo.getPrice();
        }
        return somma;
    }

    public void addToCart(Articolo art){
        //ma non esiste il push?!?!?!?!?
        Articolo[] carrelloDopo = new Articolo[this.articoli.length+1];
        System.arraycopy(this.articoli, 0, carrelloDopo, 0, this.articoli.length);
        carrelloDopo[this.articoli.length]=art;
        this.articoli=carrelloDopo;
    }
}
