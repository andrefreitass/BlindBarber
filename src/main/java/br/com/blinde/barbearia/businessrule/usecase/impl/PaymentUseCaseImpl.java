package br.com.blinde.barbearia.businessrule.usecase.impl;

import br.com.blinde.barbearia.businessrule.exception.NoSuchElementException;
import br.com.blinde.barbearia.businessrule.gateway.PaymentGateway;
import br.com.blinde.barbearia.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barbearia.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barbearia.businessrule.usecase.PaymentUseCase;
import br.com.blinde.barbearia.domain.Payment;
import br.com.blinde.barbearia.interfaceadapter.domain.request.payment.PaymentChangeRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.PaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.blinde.barbearia.businessrule.mapper.ObjectMapper.parseListObject;
import static br.com.blinde.barbearia.businessrule.mapper.ObjectMapper.parseObject;

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
    public PaymentResponse update(PaymentChangeRequest request) {

        findById(request.getId());

        Payment entity = parseObject(request, Payment.class);

        Payment payment = gateway.update(entity);

        return parseObject(payment, PaymentResponse.class);
    }
}