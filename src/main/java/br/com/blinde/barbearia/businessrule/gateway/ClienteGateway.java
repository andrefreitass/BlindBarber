package br.com.blinde.barbearia.businessrule.gateway;

import br.com.blinde.barbearia.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    Cliente create(Cliente entity);

    Cliente update(Cliente entity);

    void delete(Long id);

    Optional<Cliente> findByCpf(String id);
}
