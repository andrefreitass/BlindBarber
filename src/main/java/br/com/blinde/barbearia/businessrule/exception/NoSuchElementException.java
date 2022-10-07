package br.com.blinde.barbearia.businessrule.exception;

public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException(String message) {
        super(message);
    }
}