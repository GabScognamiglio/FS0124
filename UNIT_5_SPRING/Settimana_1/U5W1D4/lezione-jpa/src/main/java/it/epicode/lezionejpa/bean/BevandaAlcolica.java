package it.epicode.lezionejpa.bean;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;
@Entity
@Data
@ToString(callSuper = true)
public class BevandaAlcolica extends Bevanda{
    private int gradazione;
}
