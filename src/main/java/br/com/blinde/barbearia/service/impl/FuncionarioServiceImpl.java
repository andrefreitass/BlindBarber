package br.com.blinde.barbearia.service.impl;

import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import br.com.blinde.barbearia.entity.Funcionario;
import br.com.blinde.barbearia.mapper.FuncionarioMapper;
import br.com.blinde.barbearia.repository.FuncionarioRepository;
import br.com.blinde.barbearia.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository respository;

    @Autowired
    private FuncionarioMapper mapper;


    @Override
    public Page<FuncionarioResponse> buscarListaFuncionario(Pageable paginacao) {
        Page<Funcionario> funcionarios = respository.findAll(paginacao);
        return mapper.converter(funcionarios);
    }

    @Override
    public FuncionarioResponse buscarPorId(Long id) {
        Funcionario funcionario = respository.findById(id).orElseThrow();
        return mapper.converterFuncionarioParaResponse(funcionario);
    }

    @Override
    public FuncionarioResponse alterarFuncionario(FuncionarioAlterarRequest funcionarioRequest) {
        buscarPorId(funcionarioRequest.getId());
        Funcionario funcionario = mapper.converterAlterarParaFuncionario(funcionarioRequest);
        Funcionario alteracao = respository.save(funcionario);
        FuncionarioResponse funcionarioResponse = mapper.converterFuncionarioParaResponse(alteracao);

        return funcionarioResponse;
    }

    @Override
    public FuncionarioResponse incluirFuncionario(FuncionarioIncluirRequest funcionarioRequest) {
        Funcionario funcionario = mapper.converterIncluirParaFuncionario(funcionarioRequest);
        Funcionario funcionarioIncluir = respository.save(funcionario);
       return mapper.converterFuncionarioParaResponse(funcionarioIncluir);
    }


    @Override
    public void delete(Long id) {
        buscarPorId(id);
        respository.deleteById(id);
    }
}