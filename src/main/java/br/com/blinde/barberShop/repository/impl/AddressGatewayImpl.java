package br.com.blinde.barberShop.repository.impl;

import br.com.blinde.barberShop.businessrule.gateway.AddressGateway;
import br.com.blinde.barberShop.domain.Address;
import br.com.blinde.barberShop.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AddressGatewayImpl implements AddressGateway {

    private final AddressRepository repository;

    @Override
    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public Address create(Address entity) {
        return repository.save(entity);
    }

    @Override
    public Address update(Address entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}