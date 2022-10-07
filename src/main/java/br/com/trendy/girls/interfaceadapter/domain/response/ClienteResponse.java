package br.com.trendy.girls.interfaceadapter.domain.response;

import br.com.trendy.girls.interfaceadapter.enums.SexoEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse implements Serializable {

    private Long id;
    private String nome;
    private String sobreNome;
    private String cpf;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;

    private String telefone;
    private SexoEnums sexo;
}