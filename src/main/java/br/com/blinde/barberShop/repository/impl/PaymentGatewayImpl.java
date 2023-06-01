package br.com.blinde.barberShop.repository.impl;

import br.com.blinde.barberShop.businessrule.gateway.PaymentGateway;
import br.com.blinde.barberShop.domain.Payment;
import br.com.blinde.barberShop.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository repository;

    @Override
    public Optional<Payment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public Payment update(Payment entity) {
        return repository.save(entity);
    }
}