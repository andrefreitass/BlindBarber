package br.com.blinde.barberShop.businessrule.usecase;

import br.com.blinde.barberShop.interfaceadapter.domain.request.payment.PaymentChangeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.PaymentResponse;

import java.util.List;

public interface PaymentUseCase {

    PaymentResponse findById(Long id);

    List<PaymentResponse> findAll();

    PaymentResponse update(PaymentChangeRequest request);
}