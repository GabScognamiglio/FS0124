package it.epicode.lezione_jwt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentDto {
    @NotBlank(message = "Name can't be empty or null")
    private String name;
    @NotBlank(message = "Surname can't be empty or null")
    private String surname;
    @NotBlank(message = "Date of Birth can't be empty or null")
    private LocalDate dateOfBirth;
}
