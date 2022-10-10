package br.com.blinde.barberShop.businessrule.usecase;

import br.com.blinde.barberShop.interfaceadapter.domain.request.schedule.ScheduleChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.schedule.ScheduleIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientSchedulingResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeSchedulingResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.SchedulingResponse;

import java.time.LocalDate;
import java.util.List;

public interface SchedulingUseCase {

    SchedulingResponse findById(Long id);

    List<SchedulingResponse> findAll();

    SchedulingResponse create(ScheduleIncludeRequest request);

    SchedulingResponse update(ScheduleChangesRequest request);

    void delete(Long id);

    List<ClientSchedulingResponse> findByCpfClient(String cpf, LocalDate date);

    List<EmployeeSchedulingResponse> findByCpfEmployee(String cpf, LocalDate date);
}