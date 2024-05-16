package it.epicode.esgiornaliero.bean;


import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class BevandaAlcolica extends Bevanda{
    private int gradazione;
}
