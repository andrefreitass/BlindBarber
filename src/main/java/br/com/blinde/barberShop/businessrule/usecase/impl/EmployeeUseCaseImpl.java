package br.com.blinde.barberShop.businessrule.usecase.impl;

import br.com.blinde.barberShop.businessrule.exception.NoSuchElementException;
import br.com.blinde.barberShop.businessrule.gateway.EmployeeGateway;
import br.com.blinde.barberShop.businessrule.mapper.ObjectMapper;
import br.com.blinde.barberShop.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barberShop.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barberShop.businessrule.usecase.EmployeeUseCase;
import br.com.blinde.barberShop.domain.Employee;
import br.com.blinde.barberShop.interfaceadapter.domain.request.employee.EmployeeChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.employee.EmployeeIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeUseCaseImpl implements EmployeeUseCase {

    private final EmployeeGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public EmployeeResponse findById(Long id) {

        Employee entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return ObjectMapper.parseObject(entity, EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> findAll() {

        List<Employee> entity = gateway.findAll();

        return ObjectMapper.parseListObject(entity, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse create(EmployeeIncludeRequest request) {

        Employee entity = ObjectMapper.parseObject(request, Employee.class);

        Employee employee = gateway.create(entity);

        return ObjectMapper.parseObject(employee, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse update(EmployeeChangesRequest request) {

        findById(request.getId());

        Employee entity = ObjectMapper.parseObject(request, Employee.class);

        Employee employee = gateway.update(entity);

        return ObjectMapper.parseObject(employee, EmployeeResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }

    @Override
    public EmployeeResponse findByCpf(String cpf) {

        Employee entity = gateway.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), cpf)));

        return ObjectMapper.parseObject(entity, EmployeeResponse.class);
    }
}