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
    @NotBlank(message = "Inserire l'email, non può essere vuota o mancante" )
    private String email;
    @NotBlank(message = "Inserire la password, non può essere vuota o mancante" )
    private String password;
}
