package br.com.blinde.barbearia.interfaceadapter.gateway;

import br.com.blinde.barbearia.businessrule.gateway.SchedulingGateway;
import br.com.blinde.barbearia.domain.Scheduling;
import br.com.blinde.barbearia.interfaceadapter.repository.SchedulingRepository;
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
        return repository.findByClienteIdOrderByIdDesc(id);
    }

    @Override
    public List<Scheduling> findByCpfEmployee(Long id) {
        return repository.findByFuncionarioIdOrderByIdDesc(id);
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