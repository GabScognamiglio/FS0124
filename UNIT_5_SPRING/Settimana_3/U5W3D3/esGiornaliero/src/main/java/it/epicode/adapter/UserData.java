package it.epicode.adapter;

public class UserData {
    private String nomeCompleto;
    private int eta;


    public void getData(DataSource ds) {
        nomeCompleto = ds.getNomeCompleto();
        eta = ds.getEta();
    }

    public UserData(String nomeCompleto, int eta) {
        this.nomeCompleto = nomeCompleto;
        this.eta = eta;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", eta=" + eta +
                '}';
    }
}
