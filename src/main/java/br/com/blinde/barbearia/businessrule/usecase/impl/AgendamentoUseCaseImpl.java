package br.com.blinde.barbearia.businessrule.usecase.impl;

import br.com.blinde.barbearia.businessrule.exception.NoSuchElementException;
import br.com.blinde.barbearia.businessrule.gateway.AgendamentoGateway;
import br.com.blinde.barbearia.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barbearia.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barbearia.businessrule.usecase.AgendamentoUseCase;
import br.com.blinde.barbearia.domain.Agendamento;
import br.com.blinde.barbearia.domain.Cliente;
import br.com.blinde.barbearia.domain.Funcionario;
import br.com.blinde.barbearia.interfaceadapter.domain.request.agendamento.AgendamentoAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.agendamento.AgendamentoIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.AgendamentoResponse;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClienteResponse;
import br.com.blinde.barbearia.interfaceadapter.domain.response.FuncionarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.blinde.barbearia.businessrule.mapper.ObjectMapper.parseListObject;
import static br.com.blinde.barbearia.businessrule.mapper.ObjectMapper.parseObject;

@Service
@AllArgsConstructor
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    private final AgendamentoGateway gateway;

    private final ClienteUseCaseImpl clienteUseCase;

    private final FuncionarioUseCaseImpl funcionarioUseCase;

    private final MessageSourceServiceImpl message;

    @Override
    public AgendamentoResponse findById(Long id) {

        Agendamento entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return parseObject(entity, AgendamentoResponse.class);
    }

    @Override
    public List<AgendamentoResponse> findAll() {

        List<Agendamento> entity = gateway.findAll();

        return parseListObject(entity, AgendamentoResponse.class);
    }

    @Override
    public AgendamentoResponse create(AgendamentoIncluirRequest request) {

        Agendamento entity = parseObject(request, Agendamento.class);

        entity.setCliente(this.findByIdClient(request.getClienteCpf()));
        entity.setFuncionario(this.findByIdEmployee(request.getFuncionarioCpf()));

        Agendamento agendamento = gateway.create(entity);

        return parseObject(agendamento, AgendamentoResponse.class);
    }

    @Override
    public AgendamentoResponse update(AgendamentoAlterarRequest request) {

        findById(request.getId());

        Agendamento entity = parseObject(request, Agendamento.class);

        Agendamento agendamento = gateway.update(entity);

        return parseObject(agendamento, AgendamentoResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }

    @Override
    public List<AgendamentoResponse> findByCpfClient(String cpf) {

        Cliente client = this.findByIdClient(cpf);

        List<Agendamento> entity = gateway.findByCpfClient(client.getId());

        return parseListObject(entity, AgendamentoResponse.class);
    }

    @Override
    public List<AgendamentoResponse> findByCpfEmployee(String cpf) {

        Funcionario employee = this.findByIdEmployee(cpf);

        List<Agendamento> entity = gateway.findByCpfEmployee(employee.getId());

        return parseListObject(entity, AgendamentoResponse.class);
    }

    private Cliente findByIdClient(String cpf) {
        ClienteResponse client = clienteUseCase.findByCpf(cpf);
        return parseObject(client, Cliente.class);
    }

    private Funcionario findByIdEmployee(String cpf) {
        FuncionarioResponse employee = funcionarioUseCase.findByCpf(cpf);
        return parseObject(employee, Funcionario.class);
    }
}