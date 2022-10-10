package br.com.blinde.barberShop.interfaceadapter.gateway;

import br.com.blinde.barberShop.businessrule.gateway.EmployeeGateway;
import br.com.blinde.barberShop.domain.Employee;
import br.com.blinde.barberShop.interfaceadapter.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class EmployeeGatewayImpl implements EmployeeGateway {

    private final EmployeeRepository repository;

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee create(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Employee> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}