package it.epicode.esGiornaliero.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString(callSuper = true)
public class Ingrediente extends CibiMenu{
    @ManyToMany(mappedBy = "ingredienti", fetch = FetchType.EAGER)
    private List<Pizza> pizze;

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nome='" + this.getNome() + '\'' +
                ", calorie=" + getCalorie() +
                ", price=" + getPrice() +
                '}';

    }
}
