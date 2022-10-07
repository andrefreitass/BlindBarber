package br.com.blinde.barbearia.businessrule.usecase.impl;

import br.com.blinde.barbearia.businessrule.exception.NoSuchElementException;
import br.com.blinde.barbearia.businessrule.gateway.ClienteGateway;
import br.com.blinde.barbearia.businessrule.mapper.ObjectMapper;
import br.com.blinde.barbearia.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barbearia.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barbearia.businessrule.usecase.ClienteUseCase;
import br.com.blinde.barbearia.domain.Cliente;
import br.com.blinde.barbearia.interfaceadapter.domain.request.cliente.ClienteAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.cliente.ClienteIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClienteResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public ClienteResponse findById(Long id) {

        Cliente entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return ObjectMapper.parseObject(entity, ClienteResponse.class);
    }

    @Override
    public List<ClienteResponse> findAll() {

        List<Cliente> entity = gateway.findAll();

        return ObjectMapper.parseListObject(entity, ClienteResponse.class);
    }

    @Override
    public ClienteResponse create(ClienteIncluirRequest request) {

        Cliente entity = ObjectMapper.parseObject(request, Cliente.class);

        Cliente cliente = gateway.create(entity);

        return ObjectMapper.parseObject(cliente, ClienteResponse.class);
    }

    @Override
    public ClienteResponse update(ClienteAlterarRequest request) {

        findById(request.getId());

        Cliente entity = ObjectMapper.parseObject(request, Cliente.class);

        Cliente cliente = gateway.update(entity);

        return ObjectMapper.parseObject(cliente, ClienteResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }

    @Override
    public ClienteResponse findByCpf(String cpf) {

        Cliente entity = gateway.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), cpf)));

        return ObjectMapper.parseObject(entity, ClienteResponse.class);
    }
}