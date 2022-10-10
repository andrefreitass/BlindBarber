package br.com.blinde.barberShop.businessrule.gateway;

import br.com.blinde.barberShop.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentGateway {

    Optional<Payment> findById(Long id);

    List<Payment> findAll();

    Payment update(Payment entity);
}