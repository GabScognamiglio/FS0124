package it.epicode.lezione_api.exceptions;

public class StudenteNonTrovatoException extends RuntimeException {

    public StudenteNonTrovatoException(String message) {
        super(message);
    }
}
