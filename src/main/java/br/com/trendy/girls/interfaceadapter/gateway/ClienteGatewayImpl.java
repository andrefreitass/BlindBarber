package br.com.trendy.girls.interfaceadapter.gateway;

import br.com.trendy.girls.businessrule.gateway.ClienteGateway;
import br.com.trendy.girls.domain.Cliente;
import br.com.trendy.girls.interfaceadapter.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClienteGatewayImpl implements ClienteGateway {

    private final ClienteRepository repository;

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Cliente create(Cliente entity) {
        return repository.save(entity);
    }

    @Override
    public Cliente update(Cliente entity) {
        return repository.save(entity);
    }
}