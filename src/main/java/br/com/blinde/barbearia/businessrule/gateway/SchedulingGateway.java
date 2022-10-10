package br.com.blinde.barbearia.businessrule.gateway;

import br.com.blinde.barbearia.domain.Agendamento;

import java.util.List;
import java.util.Optional;

public interface SchedulingGateway {

    Optional<Agendamento> findById(Long id);

    List<Agendamento> findAll();

    Agendamento create(Agendamento entity);

    Agendamento update(Agendamento entity);

    void delete(Long id);

    List<Agendamento> findByCpfClient(Long id);

    List<Agendamento> findByCpfEmployee(Long id);
}