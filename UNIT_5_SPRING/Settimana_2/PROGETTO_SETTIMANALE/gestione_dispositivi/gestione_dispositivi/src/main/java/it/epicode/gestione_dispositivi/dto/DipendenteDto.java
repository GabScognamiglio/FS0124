package it.epicode.gestione_dispositivi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DipendenteDto {
    @NotBlank
    @Size(max = 30)
    private String username;
    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotBlank
    @Size(max = 30)
    private String cognome;
    @Email
    private String email;
}
