package br.com.blinde.barbearia.service;

import br.com.blinde.barbearia.dto.request.cliente.ClienteAlterarRequest;
import br.com.blinde.barbearia.dto.request.cliente.ClienteIncluirRequest;
import br.com.blinde.barbearia.dto.response.ClienteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    Page<ClienteResponse> buscarListaCliente(Pageable paginacao);

    ClienteResponse buscarPorId(Long id);

    ClienteResponse incluirCliente(ClienteIncluirRequest cliente);

    ClienteResponse alterarCliente(ClienteAlterarRequest cliente);

    void delete(Long id);
}
