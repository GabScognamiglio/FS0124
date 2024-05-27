package it.epicode.lezione_jwt.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
