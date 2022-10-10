package br.com.blinde.barbearia.interfaceadapter.repository;

import br.com.blinde.barbearia.domain.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findByClienteIdOrderByIdDesc(Long id);
    List<Scheduling> findByFuncionarioIdOrderByIdDesc(Long id);
}