package it.epicode.lezionejpa.bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;
@Entity
@Data
@ToString(callSuper = true)
public class Bevanda extends CibiMenu{
    private int quantitaCl;
}
