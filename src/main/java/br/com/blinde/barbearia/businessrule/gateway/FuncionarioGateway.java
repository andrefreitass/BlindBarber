package br.com.blinde.barbearia.businessrule.gateway;

import br.com.blinde.barbearia.domain.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioGateway {

    Optional<Funcionario> findById(Long id);

    List<Funcionario> findAll();

    Funcionario create(Funcionario entity);

    Funcionario update(Funcionario entity);

    void delete(Long id);

    Optional<Funcionario> findByCpf(String cpf);
}
