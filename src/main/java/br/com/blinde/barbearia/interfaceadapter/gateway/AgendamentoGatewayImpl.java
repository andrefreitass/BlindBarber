package br.com.blinde.barbearia.interfaceadapter.gateway;

import br.com.blinde.barbearia.businessrule.gateway.AgendamentoGateway;
import br.com.blinde.barbearia.domain.Agendamento;
import br.com.blinde.barbearia.interfaceadapter.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AgendamentoGatewayImpl implements AgendamentoGateway {

    private final AgendamentoRepository repository;

    @Override
    public Optional<Agendamento> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Agendamento> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Agendamento> findByCpfClient(Long id) {
        return repository.findByClienteIdOrderByIdDesc(id);
    }

    @Override
    public List<Agendamento> findByCpfEmployee(Long id) {
        return repository.findByFuncionarioIdOrderByIdDesc(id);
    }

    @Override
    public Agendamento create(Agendamento entity) {
        return repository.save(entity);
    }

    @Override
    public Agendamento update(Agendamento entity) {
        return repository.save(entity);
    }
}