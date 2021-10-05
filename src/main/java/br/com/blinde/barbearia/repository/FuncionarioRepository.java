package br.com.blinde.barbearia.repository;

import br.com.blinde.barbearia.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
