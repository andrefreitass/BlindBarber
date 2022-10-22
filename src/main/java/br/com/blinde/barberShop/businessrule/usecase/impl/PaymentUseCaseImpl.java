package br.com.blinde.barberShop.businessrule.usecase.impl;

import br.com.blinde.barberShop.businessrule.exception.NoSuchElementException;
import br.com.blinde.barberShop.businessrule.gateway.PaymentGateway;
import br.com.blinde.barberShop.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barberShop.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barberShop.businessrule.usecase.PaymentUseCase;
import br.com.blinde.barberShop.domain.Payment;
import br.com.blinde.barberShop.interfaceadapter.domain.request.payment.PaymentChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.PaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.blinde.barberShop.businessrule.mapper.ObjectMapper.parseListObject;
import static br.com.blinde.barberShop.businessrule.mapper.ObjectMapper.parseObject;

@Service
@AllArgsConstructor
public class PaymentUseCaseImpl implements PaymentUseCase {

    private final PaymentGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public PaymentResponse findById(Long id) {

        Payment entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return parseObject(entity, PaymentResponse.class);
    }

    @Override
    public List<PaymentResponse> findAll() {

        List<Payment> entity = gateway.findAll();

        return parseListObject(entity, PaymentResponse.class);
    }

    @Override
    public PaymentResponse update(PaymentChangesRequest request) {

        findById(request.getId());

        Payment entity = parseObject(request, Payment.class);

        Payment payment = gateway.update(entity);

        return parseObject(payment, PaymentResponse.class);
    }
}