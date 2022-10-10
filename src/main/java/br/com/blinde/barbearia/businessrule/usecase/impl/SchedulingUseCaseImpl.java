package br.com.blinde.barbearia.businessrule.usecase.impl;

import br.com.blinde.barbearia.businessrule.exception.NoSuchElementException;
import br.com.blinde.barbearia.businessrule.gateway.SchedulingGateway;
import br.com.blinde.barbearia.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barbearia.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barbearia.businessrule.usecase.SchedulingUseCase;
import br.com.blinde.barbearia.domain.Scheduling;
import br.com.blinde.barbearia.domain.Client;
import br.com.blinde.barbearia.domain.Employee;
import br.com.blinde.barbearia.interfaceadapter.domain.request.schedule.ScheduleChangesRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.schedule.ScheduleIncludeRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.SchedulingResponse;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClientResponse;
import br.com.blinde.barbearia.interfaceadapter.domain.response.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.blinde.barbearia.businessrule.mapper.ObjectMapper.parseListObject;
import static br.com.blinde.barbearia.businessrule.mapper.ObjectMapper.parseObject;

@Service
@AllArgsConstructor
public class SchedulingUseCaseImpl implements SchedulingUseCase {

    private final SchedulingGateway gateway;

    private final ClientUseCaseImpl clienteUseCase;

    private final EmployeeUseCaseImpl funcionarioUseCase;

    private final MessageSourceServiceImpl message;

    @Override
    public SchedulingResponse findById(Long id) {

        Scheduling entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return parseObject(entity, SchedulingResponse.class);
    }

    @Override
    public List<SchedulingResponse> findAll() {

        List<Scheduling> entity = gateway.findAll();

        return parseListObject(entity, SchedulingResponse.class);
    }

    @Override
    public SchedulingResponse create(ScheduleIncludeRequest request) {

        Scheduling entity = parseObject(request, Scheduling.class);

        entity.setClient(this.findByIdClient(request.getClienteCpf()));
        entity.setEmployee(this.findByIdEmployee(request.getFuncionarioCpf()));

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
    public List<SchedulingResponse> findByCpfClient(String cpf) {

        Client client = this.findByIdClient(cpf);

        List<Scheduling> entity = gateway.findByCpfClient(client.getId());

        return parseListObject(entity, SchedulingResponse.class);
    }

    @Override
    public List<SchedulingResponse> findByCpfEmployee(String cpf) {

        Employee employee = this.findByIdEmployee(cpf);

        List<Scheduling> entity = gateway.findByCpfEmployee(employee.getId());

        return parseListObject(entity, SchedulingResponse.class);
    }

    private Client findByIdClient(String cpf) {
        ClientResponse client = clienteUseCase.findByCpf(cpf);
        return parseObject(client, Client.class);
    }

    private Employee findByIdEmployee(String cpf) {
        EmployeeResponse employee = funcionarioUseCase.findByCpf(cpf);
        return parseObject(employee, Employee.class);
    }
}