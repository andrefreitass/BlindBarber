package br.com.blinde.barbearia.service;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.dto.request.endereco.EnderecoIncluirRequest;
import br.com.blinde.barbearia.dto.response.EnderecoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {

    Page<EnderecoResponse> buscarListaEndereco(Pageable paginacao);

    EnderecoResponse buscarId(Long id);

    EnderecoResponse incluirEndereco(EnderecoIncluirRequest enderecoIncluirRequest);

    EnderecoResponse alterarEndereco(EnderecoAlterarRequest enderecoAlterarRequest);

    void delete(Long id);
}