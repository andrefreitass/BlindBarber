package br.com.blinde.barberShop.interfaceadapter.repository;

import br.com.blinde.barberShop.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByCpf(String cpf);
}