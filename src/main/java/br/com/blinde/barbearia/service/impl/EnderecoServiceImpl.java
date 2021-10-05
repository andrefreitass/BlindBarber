package br.com.blinde.barbearia.service.impl;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.dto.request.endereco.EnderecoIncluirRequest;
import br.com.blinde.barbearia.dto.response.EnderecoResponse;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import br.com.blinde.barbearia.entity.Endereco;
import br.com.blinde.barbearia.mapper.EnderecoMapper;
import br.com.blinde.barbearia.repository.EnderecoRepository;
import br.com.blinde.barbearia.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private EnderecoMapper mapper;

    @Override
    public Page<EnderecoResponse> buscarListaEndereco(Pageable paginacao) {
        Page<Endereco> enderecos = repository.findAll(paginacao);
        return mapper.converter(enderecos);
    }

    @Override
    public EnderecoResponse buscarId(Long id) {
        Endereco endereco = repository.findById(id).orElseThrow();
        return mapper.converterEnderecoParaResponse(endereco);
    }

    @Override
    public EnderecoResponse incluirEndereco(EnderecoIncluirRequest enderecoRequest) {
        Endereco endereco = mapper.converterIncluirParaEndereco(enderecoRequest);
        Endereco enderecoIncluir = repository.save(endereco);
        return mapper.converterEnderecoParaResponse(enderecoIncluir);
    }

    @Override
    public EnderecoResponse alterarEndereco(EnderecoAlterarRequest enderecoRequest) {
        buscarId(enderecoRequest.getId());
        Endereco endereco = mapper.converterAlterarParaEndereco(enderecoRequest);
        Endereco alteracao = repository.save(endereco);
        return mapper.converterEnderecoParaResponse(alteracao);
    }

    @Override
    public void delete(Long id) {
        buscarId(id);
        repository.deleteById(id);
    }
}