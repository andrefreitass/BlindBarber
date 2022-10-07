package br.com.blinde.barbearia.businessrule.usecase;

import br.com.blinde.barbearia.interfaceadapter.domain.request.agendamento.AgendamentoAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.agendamento.AgendamentoIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.AgendamentoResponse;

import java.util.List;

public interface AgendamentoUseCase {

    AgendamentoResponse findById(Long id);

    List<AgendamentoResponse> findAll();

    AgendamentoResponse create(AgendamentoIncluirRequest request);

    AgendamentoResponse update(AgendamentoAlterarRequest request);

    void delete(Long id);

    List<AgendamentoResponse> findByCpfClient(String cpf);

    List<AgendamentoResponse> findByCpfEmployee(String cpf);
}