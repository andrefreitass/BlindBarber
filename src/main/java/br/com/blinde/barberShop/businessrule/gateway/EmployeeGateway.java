package br.com.blinde.barberShop.businessrule.gateway;

import br.com.blinde.barberShop.domain.Employee;

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
