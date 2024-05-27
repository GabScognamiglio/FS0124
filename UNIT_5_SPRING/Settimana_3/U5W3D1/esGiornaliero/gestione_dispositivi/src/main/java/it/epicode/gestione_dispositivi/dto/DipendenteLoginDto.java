package it.epicode.gestione_dispositivi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteLoginDto {


    @Email
    @NotBlank(message = "Inserire l'email, non può essere vuota o mancante")
    private String email;
    @NotBlank(message = "Inserire la password, non può essere vuota o mancante")
    private String password;


}
