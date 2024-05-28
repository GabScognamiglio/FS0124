package it.epicode.lezione_jwt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {



    private String name;
    private String surname;
    @Email
    @NotBlank(message = "Inserire l'email, non può essere vuota o mancante" )
    private String email;
    @NotBlank(message = "Inserire la password, non può essere vuota o mancante" )
    private String password;

}
