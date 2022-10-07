package br.com.blinde.barbearia.businessrule.usecase;

import br.com.blinde.barbearia.interfaceadapter.domain.request.cliente.ClienteAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.cliente.ClienteIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClienteResponse;

import java.util.List;

public interface ClienteUseCase {

    ClienteResponse findById(Long id);

    List<ClienteResponse> findAll();

    ClienteResponse create(ClienteIncluirRequest request);

    ClienteResponse update(ClienteAlterarRequest request);

    void delete(Long id);

    ClienteResponse findByCpf(String cpf);
}