package br.com.blinde.barbearia.businessrule.usecase.impl;

import br.com.blinde.barbearia.businessrule.exception.NoSuchElementException;
import br.com.blinde.barbearia.businessrule.gateway.FuncionarioGateway;
import br.com.blinde.barbearia.businessrule.mapper.ObjectMapper;
import br.com.blinde.barbearia.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barbearia.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barbearia.businessrule.usecase.FuncionarioUseCase;
import br.com.blinde.barbearia.domain.Funcionario;
import br.com.blinde.barbearia.interfaceadapter.domain.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.FuncionarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioUseCaseImpl implements FuncionarioUseCase {

    private final FuncionarioGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public FuncionarioResponse findById(Long id) {

        Funcionario entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return ObjectMapper.parseObject(entity, FuncionarioResponse.class);
    }

    @Override
    public List<FuncionarioResponse> findAll() {

        List<Funcionario> entity = gateway.findAll();

        return ObjectMapper.parseListObject(entity, FuncionarioResponse.class);
    }

    @Override
    public FuncionarioResponse create(FuncionarioIncluirRequest request) {

        Funcionario entity = ObjectMapper.parseObject(request, Funcionario.class);

        Funcionario employee = gateway.create(entity);

        return ObjectMapper.parseObject(employee, FuncionarioResponse.class);
    }

    @Override
    public FuncionarioResponse update(FuncionarioAlterarRequest request) {

        findById(request.getId());

        Funcionario entity = ObjectMapper.parseObject(request, Funcionario.class);

        Funcionario employee = gateway.update(entity);

        return ObjectMapper.parseObject(employee, FuncionarioResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }

    @Override
    public FuncionarioResponse findByCpf(String cpf) {

        Funcionario entity = gateway.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), cpf)));

        return ObjectMapper.parseObject(entity, FuncionarioResponse.class);
    }
}