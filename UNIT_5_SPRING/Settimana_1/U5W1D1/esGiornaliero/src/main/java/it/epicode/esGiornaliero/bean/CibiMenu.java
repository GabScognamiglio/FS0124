package it.epicode.esGiornaliero.bean;

import lombok.Data;
import lombok.ToString;

@Data
public abstract class CibiMenu {
    private String nome;
    private int calorie;
    private double price;

    @Override
    public String toString() {
        return "CibiMenu{" +
                "nome='" + nome + '\'' +
                ", calorie=" + calorie +
                ", price=" + price +
                '}';
    }
}
