package br.com.blinde.barbearia.repository;

import br.com.blinde.barbearia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
