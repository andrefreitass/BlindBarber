package br.com.blinde.barberShop.businessrule.gateway;

import br.com.blinde.barberShop.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressGateway {

    Optional<Address> findById(Long id);

    List<Address> findAll();

    Address create(Address entity);

    Address update(Address entity);

    void delete(Long id);
}