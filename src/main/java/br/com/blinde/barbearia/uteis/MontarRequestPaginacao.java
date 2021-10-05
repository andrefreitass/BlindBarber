package br.com.blinde.barbearia.uteis;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class MontarRequestPaginacao {

    private int pagina;
    private int quantidadePagina;
    private Sort.Direction ordenacao;
    private String objetoOrdenacao;

    public MontarRequestPaginacao() {
    }

    public MontarRequestPaginacao(int pagina, int quantidadePagina, Sort.Direction ordenacao, String objetoOrdenacao) {
        this.pagina = pagina;
        this.quantidadePagina = quantidadePagina;
        this.ordenacao = ordenacao;
        this.objetoOrdenacao = objetoOrdenacao;
    }

    public PageRequest requestPaginacao(){
        return PageRequest.of(pagina, quantidadePagina, ordenacao, objetoOrdenacao);
    }
}
