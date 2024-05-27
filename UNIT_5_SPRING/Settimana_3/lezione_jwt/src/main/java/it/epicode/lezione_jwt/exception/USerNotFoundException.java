package it.epicode.lezione_jwt.exception;

public class USerNotFoundException extends RuntimeException{
    public USerNotFoundException(String message) {
        super(message);
    }
}
