package br.com.blinde.barberShop.businessrule.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTypeEnum {

    NOT_FOUND("not-found"),
    NOT_VALID("not-valid"),
    ERROR_PARSE("error_parse"),
    ERROR_CONVERTER("error_converter");

    private final String message;
}