package br.com.blinde.barbearia.interfaceadapter.repository;

import br.com.blinde.barbearia.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByClienteIdOrderByIdDesc(Long id);
    List<Agendamento> findByFuncionarioIdOrderByIdDesc(Long id);
}