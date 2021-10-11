package br.com.blinde.barbearia.service;

import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoAlterarRequest;
import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoIncluirRequest;
import br.com.blinde.barbearia.dto.response.AgendamentoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgendamentoService {

    AgendamentoResponse buscarPorId(Long id);

    Page<AgendamentoResponse> buscarListaAgendamentos(Pageable paginacao);

    AgendamentoResponse incluirAgendamento(AgendamentoIncluirRequest agendamento);

    AgendamentoResponse alterarAgendamento(AgendamentoAlterarRequest agendamento);

    void delete(Long id);
}
