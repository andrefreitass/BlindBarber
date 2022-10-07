package br.com.blinde.barbearia.interfaceadapter.gateway;

import br.com.blinde.barbearia.businessrule.gateway.FuncionarioGateway;
import br.com.blinde.barbearia.domain.Funcionario;
import br.com.blinde.barbearia.interfaceadapter.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class FuncionarioGatewayImpl implements FuncionarioGateway {

    private final FuncionarioRepository repository;

    @Override
    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Funcionario create(Funcionario entity) {
        return repository.save(entity);
    }

    @Override
    public Funcionario update(Funcionario entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Funcionario> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}