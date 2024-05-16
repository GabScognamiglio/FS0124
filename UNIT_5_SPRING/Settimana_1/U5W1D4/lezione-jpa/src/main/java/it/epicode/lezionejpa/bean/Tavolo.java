package it.epicode.lezionejpa.bean;

import lombok.Data;

@Data
public class Tavolo {
    private int numTavolo;
    private int maxCoperti;
    private StatoTavolo stato;

}
