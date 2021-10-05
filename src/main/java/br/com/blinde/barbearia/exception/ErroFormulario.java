package br.com.blinde.barbearia.exception;

import lombok.Getter;

@Getter
public class ErroFormulario {
    private String campo;
    private String erro;

    public ErroFormulario(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
