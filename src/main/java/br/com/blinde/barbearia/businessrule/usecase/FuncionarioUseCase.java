package br.com.blinde.barbearia.businessrule.usecase;

import br.com.blinde.barbearia.interfaceadapter.domain.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.FuncionarioResponse;

import java.util.List;

public interface FuncionarioUseCase {

    FuncionarioResponse findById(Long id);

    List<FuncionarioResponse> findAll();

    FuncionarioResponse create(FuncionarioIncluirRequest request);

    FuncionarioResponse update(FuncionarioAlterarRequest request);

    void delete(Long id);

    FuncionarioResponse findByCpf(String cpf);
}