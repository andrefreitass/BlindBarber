package br.com.blinde.barberShop.businessrule.gateway;

import br.com.blinde.barberShop.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientGateway {

    Optional<Client> findById(Long id);

    List<Client> findAll();

    Client create(Client entity);

    Client update(Client entity);

    void delete(Long id);

//    Optional<Client> findByCpf(String id);
}
