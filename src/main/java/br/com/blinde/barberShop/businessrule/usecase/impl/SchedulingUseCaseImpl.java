package br.com.blinde.barberShop.businessrule.usecase.impl;

import br.com.blinde.barberShop.businessrule.exception.NoSuchElementException;
import br.com.blinde.barberShop.businessrule.gateway.SchedulingGateway;
import br.com.blinde.barberShop.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barberShop.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barberShop.businessrule.usecase.SchedulingUseCase;
import br.com.blinde.barberShop.domain.Client;
import br.com.blinde.barberShop.domain.Employee;
import br.com.blinde.barberShop.domain.Scheduling;
import br.com.blinde.barberShop.interfaceadapter.domain.request.schedule.ScheduleChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.schedule.ScheduleIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientSchedulingResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeSchedulingResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.SchedulingResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static br.com.blinde.barberShop.businessrule.mapper.ObjectMapper.parseListObject;
import static br.com.blinde.barberShop.businessrule.mapper.ObjectMapper.parseObject;

@Service
@AllArgsConstructor
public class SchedulingUseCaseImpl implements SchedulingUseCase {

    private final SchedulingGateway gateway;

    private final ClientUseCaseImpl clientUseCase;

    private final EmployeeUseCaseImpl employeeUseCase;

    private final MessageSourceServiceImpl message;

    @Override
    public SchedulingResponse findById(Long id) {

        Scheduling entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return parseObject(entity, SchedulingResponse.class);
    }

    @Override
    public List<SchedulingResponse> findAll(LocalDate date) {

        List<Scheduling> entity = gateway.findAll(date);

        return parseListObject(entity, SchedulingResponse.class);
    }

    @Override
    public SchedulingResponse create(ScheduleIncludeRequest request) {

        Scheduling entity = parseObject(request, Scheduling.class);

        entity.setClient(this.findByIdClient(request.getClientCpf()));
        entity.setEmployee(this.findByIdEmployee(request.getEmployeeCpf()));

        Scheduling scheduling = gateway.create(entity);

        return parseObject(scheduling, SchedulingResponse.class);
    }

    @Override
    public SchedulingResponse update(ScheduleChangesRequest request) {

        findById(request.getId());

        Scheduling entity = parseObject(request, Scheduling.class);

        Scheduling scheduling = gateway.update(entity);

        return parseObject(scheduling, SchedulingResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }

    @Override
    public List<ClientSchedulingResponse> findByCpfClient(String cpf, LocalDate date) {

        Client client = this.findByIdClient(cpf);

        List<Scheduling> entity = gateway.findByCpfClient(client.getId(), date);

        return parseListObject(entity, ClientSchedulingResponse.class);
    }

    @Override
    public List<EmployeeSchedulingResponse> findByCpfEmployee(String cpf, LocalDate date) {

        Employee employee = this.findByIdEmployee(cpf);

        List<Scheduling> entity = gateway.findByCpfEmployee(employee.getId(), date);

        return parseListObject(entity, EmployeeSchedulingResponse.class);
    }

    private Client findByIdClient(String cpf) {
        ClientResponse client = clientUseCase.findByCpf(cpf);
        return parseObject(client, Client.class);
    }

    private Employee findByIdEmployee(String cpf) {
        EmployeeResponse employee = employeeUseCase.findByCpf(cpf);
        return parseObject(employee, Employee.class);
    }
}