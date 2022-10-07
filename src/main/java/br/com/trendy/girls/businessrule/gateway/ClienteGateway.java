package br.com.trendy.girls.businessrule.gateway;

import br.com.trendy.girls.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    Cliente create(Cliente entity);

    Cliente update(Cliente entity);

    void delete(Long id);
}
