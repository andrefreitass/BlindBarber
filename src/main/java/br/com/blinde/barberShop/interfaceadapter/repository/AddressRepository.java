package br.com.blinde.barberShop.interfaceadapter.repository;

import br.com.blinde.barberShop.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}