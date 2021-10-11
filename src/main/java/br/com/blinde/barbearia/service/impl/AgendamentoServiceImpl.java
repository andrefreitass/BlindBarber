package br.com.blinde.barbearia.service.impl;

import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoAlterarRequest;
import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoIncluirRequest;
import br.com.blinde.barbearia.dto.response.AgendamentoResponse;
import br.com.blinde.barbearia.entity.Agendamento;
import br.com.blinde.barbearia.mapper.AgendamentoMapper;
import br.com.blinde.barbearia.repository.AgendamentoRepository;
import br.com.blinde.barbearia.repository.ClienteRepository;
import br.com.blinde.barbearia.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private AgendamentoMapper mapper;

    @Override
    public AgendamentoResponse buscarPorId(Long id) {
        Agendamento agendamento = repository.findById(id).orElseThrow();
        return mapper.converterAgendamentoResponse(agendamento);
    }

    @Override
    public Page<AgendamentoResponse> buscarListaAgendamentos(Pageable paginacao) {
        Page<Agendamento> agendamentoPage = repository.findAll(paginacao);
        return mapper.converter(agendamentoPage);
    }

    @Override
    public AgendamentoResponse incluirAgendamento(AgendamentoIncluirRequest agendamentoIncluirRequest) {
        Agendamento agendamento = mapper.converterIncluirAgendamento(agendamentoIncluirRequest);
        Agendamento agendamentoIncluir = repository.save(agendamento);
        return mapper.converterAgendamentoResponse(agendamentoIncluir);
    }

    @Override
    public AgendamentoResponse alterarAgendamento(AgendamentoAlterarRequest agendamento) {
        buscarPorId(agendamento.getId());
        Agendamento agendamentoAlteracao = mapper.converterAlterarAgendamento(agendamento);
        Agendamento agendamentoSalvarAlteracao = repository.save(agendamentoAlteracao);
        return mapper.converterAgendamentoResponse(agendamentoSalvarAlteracao);
    }

    @Override
    public void delete(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
