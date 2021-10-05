package br.com.blinde.barbearia.mapper;

import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import br.com.blinde.barbearia.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    private FuncionarioResponse response = new FuncionarioResponse();
    private Funcionario funcionario = new Funcionario();

    public FuncionarioResponse converterFuncionarioParaResponse(Funcionario source) {
        response.setId(source.getId());
        response.setNome(source.getNome());
        response.setCpf(source.getCpf());
        response.setTelefone(source.getTelefone());
        response.setSexo(source.getSexo());
        response.setEndereco(enderecoMapper.converterEnderecoParaResponse(source.getEndereco()));

        return response;
    }

    public Funcionario converterIncluirParaFuncionario(FuncionarioIncluirRequest source) {
        funcionario.setId(source.getId());
        funcionario.setNome(source.getNome());
        funcionario.setCpf(source.getCpf());
        funcionario.setEndereco(enderecoMapper.converterIncluirParaEndereco(source.getEndereco()));
        funcionario.setTelefone(source.getTelefone());
        funcionario.setSexo(source.getSexo());

        return funcionario;
    }

    public Funcionario converterAlterarParaFuncionario(FuncionarioAlterarRequest source) {
        funcionario.setId(source.getId());
        funcionario.setNome(source.getNome());
        funcionario.setCpf(source.getCpf());
        funcionario.setEndereco(enderecoMapper.converterAlterarParaEndereco(source.getEndereco()));
        funcionario.setTelefone(source.getTelefone());
        funcionario.setSexo(source.getSexo());

        return funcionario;
    }

    public static Page<FuncionarioResponse> converter(Page<Funcionario> funcionarios) {
        return funcionarios.map(FuncionarioResponse::new);
    }
}