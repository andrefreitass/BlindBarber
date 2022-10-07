package br.com.trendy.girls.businessrule.usecase.impl;

import br.com.trendy.girls.businessrule.exception.NoSuchElementException;
import br.com.trendy.girls.businessrule.gateway.ClienteGateway;
import br.com.trendy.girls.businessrule.messages.MessageSourceServiceImpl;
import br.com.trendy.girls.businessrule.usecase.ClienteUseCase;
import br.com.trendy.girls.domain.Cliente;
import br.com.trendy.girls.interfaceadapter.domain.request.ClienteAlterarRequest;
import br.com.trendy.girls.interfaceadapter.domain.request.ClienteIncluirRequest;
import br.com.trendy.girls.interfaceadapter.domain.response.ClienteResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.trendy.girls.businessrule.mapper.ObjectMapper.parseListObject;
import static br.com.trendy.girls.businessrule.mapper.ObjectMapper.parseObject;
import static br.com.trendy.girls.businessrule.messages.MessageTypeEnum.NOT_FOUND;

@Service
@AllArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public ClienteResponse findById(Long id) {

        Cliente entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(NOT_FOUND.getMessage(), id)));

        return parseObject(entity, ClienteResponse.class);
    }

    @Override
    public List<ClienteResponse> findAll() {

        List<Cliente> entity = gateway.findAll();

        return parseListObject(entity, ClienteResponse.class);
    }

    @Override
    public ClienteResponse create(ClienteIncluirRequest request) {

        Cliente entity = parseObject(request, Cliente.class);

        Cliente cliente = gateway.create(entity);

        return parseObject(cliente, ClienteResponse.class);
    }

    @Override
    public ClienteResponse update(ClienteAlterarRequest request) {

        findById(request.getId());

        Cliente entity = parseObject(request, Cliente.class);

        Cliente cliente = gateway.update(entity);

        return parseObject(cliente, ClienteResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }
}