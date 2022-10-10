package br.com.blinde.barbearia.businessrule.usecase;

import br.com.blinde.barbearia.interfaceadapter.domain.request.client.ClientChangesRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.client.ClientIncludeRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClientResponse;

import java.util.List;

public interface ClientUseCase {

    ClientResponse findById(Long id);

    List<ClientResponse> findAll();

    ClientResponse create(ClientIncludeRequest request);

    ClientResponse update(ClientChangesRequest request);

    void delete(Long id);

    ClientResponse findByCpf(String cpf);
}