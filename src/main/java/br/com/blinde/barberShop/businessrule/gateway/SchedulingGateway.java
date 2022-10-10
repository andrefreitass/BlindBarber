package br.com.blinde.barberShop.businessrule.gateway;

import br.com.blinde.barberShop.domain.Scheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SchedulingGateway {

    Optional<Scheduling> findById(Long id);

    List<Scheduling> findAll();

    Scheduling create(Scheduling entity);

    Scheduling update(Scheduling entity);

    void delete(Long id);

    List<Scheduling> findByCpfClient(Long id, LocalDate date);

    List<Scheduling> findByCpfEmployee(Long id, LocalDate date);
}