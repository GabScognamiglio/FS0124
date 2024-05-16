package it.epicode.esGiornaliero.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

import java.util.List;
@Entity
@Data
@ToString(callSuper = true)
public class Pizza extends CibiMenu{
    @ManyToMany
    @JoinTable(
            name = "pizza_ingredienti",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredienti;
}
