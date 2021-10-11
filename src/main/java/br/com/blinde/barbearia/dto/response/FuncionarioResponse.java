package br.com.blinde.barbearia.dto.response;

import br.com.blinde.barbearia.entity.Funcionario;
import br.com.blinde.barbearia.enums.SexoEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponse {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private EnderecoResponse endereco;
    private SexoEnums sexo;

    public FuncionarioResponse(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.telefone = funcionario.getTelefone();
        this.cpf = funcionario.getCpf();
        this.endereco = new EnderecoResponse(funcionario.getEndereco());
        this.sexo = funcionario.getSexo();
    }
}