package it.epicode.gestione_dispositivi.dto;

import it.epicode.gestione_dispositivi.model.StatoDispositivo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SmartphoneDto {
    @NotBlank
    private String marca;
    @NotBlank
    private String modello;
    private double polliciSchermo;
    @NotBlank
    private String statoDispositivo;
    private double megapixel;
}
