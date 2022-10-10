package br.com.blinde.barberShop.interfaceadapter.repository;

import br.com.blinde.barberShop.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}