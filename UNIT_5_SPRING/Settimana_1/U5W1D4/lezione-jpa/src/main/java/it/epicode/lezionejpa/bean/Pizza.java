package it.epicode.lezionejpa.bean;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@Entity
public class Pizza extends CibiMenu{
    @ManyToMany
    @JoinTable(
            name = "pizza_ingrediente",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredienti;
}
