package it.epicode.chain;

public class Ufficiale {
   protected Ufficiale superiore;
   protected int stipendio;

    public void controllaStipendio(int cifraDaControllare) {
        if(cifraDaControllare<=stipendio) {
            System.out.println("Lo stipendio di "+ getClass().getSimpleName() + " è maggiore di " + cifraDaControllare);
        }else{
            System.out.println("Lo stipendio di "+ getClass().getSimpleName() + " è MINORE di " + cifraDaControllare);
        }
        if (superiore!=null)  {
            superiore.controllaStipendio(cifraDaControllare);
        }
        else {
            System.out.println("FINE CATENA.");
        }
    }


    public Ufficiale getSuperiore() {
        return superiore;
    }

    public void setSuperiore(Ufficiale superiore) {
        this.superiore = superiore;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }
}
