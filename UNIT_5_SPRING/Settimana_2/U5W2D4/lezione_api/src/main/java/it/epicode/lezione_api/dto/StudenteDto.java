package it.epicode.lezione_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {
    @NotNull
    @Size(max = 30)
    private String nome;
    @NotNull
    @Size(max = 30)
    private String cognome;
    private LocalDate dataNascita;

    @Email
    private String email;

    @NotNull
    private int aulaId;


}
