package br.com.blinde.barbearia.businessrule.gateway;

import br.com.blinde.barbearia.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeGateway {

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Employee create(Employee entity);

    Employee update(Employee entity);

    void delete(Long id);

    Optional<Employee> findByCpf(String cpf);
}
