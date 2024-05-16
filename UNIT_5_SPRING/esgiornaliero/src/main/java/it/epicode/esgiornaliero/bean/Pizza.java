package it.epicode.esgiornaliero.bean;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@Entity
public class Pizza extends CibiMenu{
//    private List<Ingrediente> ingredienti;
}
