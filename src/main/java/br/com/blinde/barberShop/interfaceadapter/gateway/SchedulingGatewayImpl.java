package br.com.blinde.barberShop.interfaceadapter.gateway;

import br.com.blinde.barberShop.businessrule.gateway.SchedulingGateway;
import br.com.blinde.barberShop.domain.Scheduling;
import br.com.blinde.barberShop.interfaceadapter.repository.SchedulingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
    public List<Scheduling> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Scheduling> findByCpfClient(Long id) {
        return repository.findByClientIdOrderByIdDesc(id);
    }

    @Override
    public List<Scheduling> findByCpfEmployee(Long id) {
        return repository.findByEmployeeIdOrderByIdDesc(id);
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