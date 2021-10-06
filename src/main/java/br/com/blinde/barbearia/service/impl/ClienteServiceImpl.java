package br.com.blinde.barbearia.service.impl;

import br.com.blinde.barbearia.dto.request.cliente.ClienteAlterarAgendamentoRequest;
import br.com.blinde.barbearia.dto.request.cliente.ClienteAlterarRequest;
import br.com.blinde.barbearia.dto.request.cliente.ClienteIncluirRequest;
import br.com.blinde.barbearia.dto.response.ClienteResponse;
import br.com.blinde.barbearia.entity.Cliente;
import br.com.blinde.barbearia.mapper.ClienteMapper;
import br.com.blinde.barbearia.repository.ClienteRepository;
import br.com.blinde.barbearia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public Page<ClienteResponse> buscarListaCliente(Pageable paginacao) {
        Page<Cliente> clientes = repository.findAll(paginacao);
        return mapper.converter(clientes);
    }

    @Override
    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow();
        return mapper.converterClienteParaResponse(cliente);
    }

    @Override
    public ClienteResponse incluirCliente(ClienteIncluirRequest clienteIncluirRequest) {
        Cliente cliente = mapper.converterIncluirParaCliente(clienteIncluirRequest);
        Cliente clienteIncluir = repository.save(cliente);
        return mapper.converterClienteParaResponse(clienteIncluir);
    }

    @Override
    public ClienteResponse alterarCliente(ClienteAlterarRequest clienteAlterarRequest) {
        buscarPorId(clienteAlterarRequest.getId());
        Cliente cliente = mapper.converterAlterarParaCliente(clienteAlterarRequest);
        Cliente alteracao = repository.save(cliente);
        return mapper.converterClienteParaResponse(alteracao);
    }

    @Override
    public ClienteResponse alterarAgendamentoCliente(ClienteAlterarAgendamentoRequest agendamentoRequest) {
        buscarPorId(agendamentoRequest.getId());
        Cliente cliente = mapper.converterAlterarAgendamentoParaCliente(agendamentoRequest);
        Cliente alteracaoAgendamento = repository.save(cliente);
        return mapper.converterClienteParaResponse(alteracaoAgendamento);
    }

    @Override
    public void delete(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}