package it.epicode.gestione_dispositivi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "laptops")
public class Laptop extends Dispositivo{
    private int ram;
    private int ssd;
}
