package br.com.blinde.barberShop.businessrule.messages;

public interface MessageSourceService {

    String getMessage(String message);

    String getMessage(String message, Object... args);
}