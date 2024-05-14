package it.epicode.esGiornaliero.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Bevanda extends CibiMenu{
    private int quantitaCl;
}
