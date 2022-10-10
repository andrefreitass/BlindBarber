package br.com.blinde.barbearia.businessrule.usecase.impl;

import br.com.blinde.barbearia.businessrule.exception.NoSuchElementException;
import br.com.blinde.barbearia.businessrule.gateway.ClientGateway;
import br.com.blinde.barbearia.businessrule.mapper.ObjectMapper;
import br.com.blinde.barbearia.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barbearia.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barbearia.businessrule.usecase.ClientUseCase;
import br.com.blinde.barbearia.domain.Client;
import br.com.blinde.barbearia.interfaceadapter.domain.request.client.ClientChangesRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.client.ClientIncludeRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    private final ClientGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public ClientResponse findById(Long id) {

        Client entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return ObjectMapper.parseObject(entity, ClientResponse.class);
    }

    @Override
    public List<ClientResponse> findAll() {

        List<Client> entity = gateway.findAll();

        return ObjectMapper.parseListObject(entity, ClientResponse.class);
    }

    @Override
    public ClientResponse create(ClientIncludeRequest request) {

        Client entity = ObjectMapper.parseObject(request, Client.class);

        Client client = gateway.create(entity);

        return ObjectMapper.parseObject(client, ClientResponse.class);
    }

    @Override
    public ClientResponse update(ClientChangesRequest request) {

        findById(request.getId());

        Client entity = ObjectMapper.parseObject(request, Client.class);

        Client client = gateway.update(entity);

        return ObjectMapper.parseObject(client, ClientResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }

    @Override
    public ClientResponse findByCpf(String cpf) {

        Client entity = gateway.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), cpf)));

        return ObjectMapper.parseObject(entity, ClientResponse.class);
    }
}