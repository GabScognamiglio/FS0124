package it.epicode.esgiornaliero.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public abstract class CibiMenu {
    @Id
    @GeneratedValue
    private int id;
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
