package it.epicode.esGiornaliero.bean;


import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class Pizza extends CibiMenu{
    private List<Ingrediente> ingredienti;
}
