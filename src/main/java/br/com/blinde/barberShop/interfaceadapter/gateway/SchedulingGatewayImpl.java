package br.com.blinde.barberShop.interfaceadapter.gateway;

import br.com.blinde.barberShop.businessrule.gateway.SchedulingGateway;
import br.com.blinde.barberShop.domain.Scheduling;
import br.com.blinde.barberShop.interfaceadapter.repository.SchedulingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SchedulingGatewayImpl implements SchedulingGateway {

    private final SchedulingRepository repository;

    @Override
    public Optional<Scheduling> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Scheduling> findAll(LocalDate date) {
        return repository.findByDateOrderByHourDesc(date);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Scheduling> findByCpfClient(Long id, LocalDate date) {
        return repository.findByClientIdAndDateOrderByIdDesc(id,date);
    }

    @Override
    public List<Scheduling> findByCpfEmployee(Long id, LocalDate date) {
        return repository.findByEmployeeIdAndDateOrderByIdDesc(id, date);
    }

    @Override
    public Scheduling create(Scheduling entity) {
        return repository.save(entity);
    }

    @Override
    public Scheduling update(Scheduling entity) {
        return repository.save(entity);
    }
}