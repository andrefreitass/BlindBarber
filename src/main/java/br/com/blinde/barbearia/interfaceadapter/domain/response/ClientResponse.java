package br.com.blinde.barbearia.interfaceadapter.domain.response;

import br.com.blinde.barbearia.interfaceadapter.enums.SexoEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse implements Serializable {

    private Long id;
    private String nome;
    private String sobreNome;
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String telefone;
    private SexoEnums sexo;
}