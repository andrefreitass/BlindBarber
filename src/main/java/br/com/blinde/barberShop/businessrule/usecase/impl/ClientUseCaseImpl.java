package br.com.blinde.barberShop.businessrule.usecase.impl;

import br.com.blinde.barberShop.businessrule.gateway.ClientGatewayRepository;
import br.com.blinde.barberShop.businessrule.mapper.ClienteMapper;
import br.com.blinde.barberShop.businessrule.usecase.ClientUseCase;
import br.com.blinde.barberShop.domain.Client;
import br.com.blinde.barberShop.interfaceadapter.domain.request.client.ClientChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.client.ClientIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    private final ClientGatewayRepository repository;

    private final ClienteMapper mapper;

    @Override
    public ClientResponse findById(Long id) {
        Client data = repository.findById(id).orElseThrow();
        return mapper.clientFromClientResponse(data);
    }

    @Override
    public List<ClientResponse> findAll() {
        List<Client> data = repository.findAll();
        return mapper.clientFromClientResponse(data);
    }

    @Override
    public ClientResponse create(ClientIncludeRequest request) {
        Client data = repository.create(mapper.clientIncludeRequestFromClient(request));
        return mapper.clientFromClientResponse(data);
    }

    @Override
    public ClientResponse update(ClientChangesRequest request) {
        Client data = repository.update(mapper.clientChangesRequestFromClient(request));
        return mapper.clientFromClientResponse(data);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.delete(id);
    }

    @Override
    public ClientResponse findByCpf(String cpf) {
        Client data = repository.findByCpf(cpf).orElseThrow();
        return mapper.clientFromClientResponse(data);
    }
}
