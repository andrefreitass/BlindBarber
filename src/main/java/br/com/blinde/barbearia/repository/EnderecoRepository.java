package br.com.blinde.barbearia.repository;

import br.com.blinde.barbearia.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}