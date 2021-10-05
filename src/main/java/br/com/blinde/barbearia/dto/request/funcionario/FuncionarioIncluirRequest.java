package br.com.blinde.barbearia.dto.request.funcionario;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoIncluirRequest;
import br.com.blinde.barbearia.enums.SexoEnums;
import br.com.blinde.barbearia.uteis.beans.Cpf;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioIncluirRequest {

    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Pattern(regexp="(\\d{3})-\\d{5}-\\d{4}$")
    private String telefone;

    @Cpf
    private String cpf;

    @NotNull
    @Valid
    private EnderecoIncluirRequest endereco;

    @NotNull
    private SexoEnums sexo;
}
