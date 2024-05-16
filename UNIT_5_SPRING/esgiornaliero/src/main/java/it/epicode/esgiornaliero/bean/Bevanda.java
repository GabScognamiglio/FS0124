package it.epicode.esgiornaliero.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Bevanda extends CibiMenu{
    private int quantitaCl;
}
