package it.epicode.lezione_api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AulaDto {
    @NotNull(message = "Il campo nome non può essere null")
    @Size(max = 30)
    private String nome;

    @Min(0)
    @Max(3)
    private int piano;
}
