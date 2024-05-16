package it.epicode.esGiornaliero.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString(callSuper = true)
public class Ingrediente extends CibiMenu{
    @ManyToMany(mappedBy = "ingredienti")
    private List<Pizza> pizze;
}
