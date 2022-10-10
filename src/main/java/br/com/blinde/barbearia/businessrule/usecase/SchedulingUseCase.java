package br.com.blinde.barbearia.businessrule.usecase;

import br.com.blinde.barbearia.interfaceadapter.domain.request.schedule.ScheduleChangesRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.schedule.ScheduleIncludeRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.SchedulingResponse;

import java.util.List;

public interface SchedulingUseCase {

    SchedulingResponse findById(Long id);

    List<SchedulingResponse> findAll();

    SchedulingResponse create(ScheduleIncludeRequest request);

    SchedulingResponse update(ScheduleChangesRequest request);

    void delete(Long id);

    List<SchedulingResponse> findByCpfClient(String cpf);

    List<SchedulingResponse> findByCpfEmployee(String cpf);
}