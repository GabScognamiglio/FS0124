package it.epicode.esGiornaliero.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CibiMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
