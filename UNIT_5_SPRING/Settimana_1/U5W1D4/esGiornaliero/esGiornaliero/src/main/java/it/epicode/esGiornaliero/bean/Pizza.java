package it.epicode.esGiornaliero.bean;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ManyToAny;

import java.util.List;
@Entity
@Data
@ToString(callSuper = true)
public class Pizza extends CibiMenu{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pizza_ingredienti",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )

    private List<Ingrediente> ingredienti;
}
