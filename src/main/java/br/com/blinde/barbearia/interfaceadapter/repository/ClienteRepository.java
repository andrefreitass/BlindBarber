package br.com.blinde.barbearia.interfaceadapter.repository;

import br.com.blinde.barbearia.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}