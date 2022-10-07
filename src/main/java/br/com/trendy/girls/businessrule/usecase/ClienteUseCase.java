package br.com.trendy.girls.businessrule.usecase;

import br.com.trendy.girls.interfaceadapter.domain.request.ClienteAlterarRequest;
import br.com.trendy.girls.interfaceadapter.domain.request.ClienteIncluirRequest;
import br.com.trendy.girls.interfaceadapter.domain.response.ClienteResponse;

import java.util.List;

public interface ClienteUseCase {

    ClienteResponse findById(Long id);

    List<ClienteResponse> findAll();

    ClienteResponse create(ClienteIncluirRequest request);

    ClienteResponse update(ClienteAlterarRequest request);

    void delete(Long id);
}