package br.com.blinde.barbearia.dto.request.funcionario;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.enums.SexoEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioAlterarRequest {

    @NotNull
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Pattern(regexp="(\\d{3})-\\d{5}-\\d{4}$")
    private String telefone;

    @CPF
    private String cpf;

    @NotNull
    @Valid
    private EnderecoAlterarRequest endereco;

    @NotNull
    private SexoEnums sexo;
}
