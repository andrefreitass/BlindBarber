package br.com.blinde.barbearia.repository;

import br.com.blinde.barbearia.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}