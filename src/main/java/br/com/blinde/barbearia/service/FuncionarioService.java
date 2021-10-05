package br.com.blinde.barbearia.service;

import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FuncionarioService {

    Page<FuncionarioResponse> buscarListaFuncionario(Pageable paginacao);

    FuncionarioResponse buscarPorId(Long id);

    FuncionarioResponse incluirFuncionario(FuncionarioIncluirRequest funcionarioRequest);

    FuncionarioResponse alterarFuncionario(FuncionarioAlterarRequest funcionarioRequest);

    void delete(Long id);



}
