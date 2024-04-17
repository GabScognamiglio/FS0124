package telefonia;

public class UsaSimCard {
    public static void main(String[] args) {
        SimCard simCard = new SimCard(333456786);
        simCard.setCredito(50);

        Chiamata[] chiamate = new Chiamata[5];
        chiamate[0]= new Chiamata(15,334578754);
        chiamate[1]= new Chiamata(7,335415587);
        chiamate[2]= new Chiamata(12,393247835);
        chiamate[3]= new Chiamata(41,365465754);
        chiamate[4]= new Chiamata(1,353457874);

        simCard.setUltimeCinque(chiamate);

        simCard.stampaSim();
    }
}
