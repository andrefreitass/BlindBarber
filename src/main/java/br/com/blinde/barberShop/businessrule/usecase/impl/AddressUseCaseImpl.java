package br.com.blinde.barberShop.businessrule.usecase.impl;

import br.com.blinde.barberShop.businessrule.exception.NoSuchElementException;
import br.com.blinde.barberShop.businessrule.gateway.AddressGateway;
import br.com.blinde.barberShop.businessrule.mapper.ObjectMapper;
import br.com.blinde.barberShop.businessrule.messages.MessageSourceServiceImpl;
import br.com.blinde.barberShop.businessrule.messages.MessageTypeEnum;
import br.com.blinde.barberShop.businessrule.usecase.AddressUseCase;
import br.com.blinde.barberShop.domain.Address;
import br.com.blinde.barberShop.interfaceadapter.domain.request.address.AddressChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.address.AddressIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.AddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressUseCaseImpl implements AddressUseCase {

    private final AddressGateway gateway;

    private final MessageSourceServiceImpl message;

    @Override
    public AddressResponse findById(Long id) {

        Address entity = gateway.findById(id).orElseThrow(() ->
                new NoSuchElementException(message.getMessage(MessageTypeEnum.NOT_FOUND.getMessage(), id)));

        return ObjectMapper.parseObject(entity, AddressResponse.class);
    }

    @Override
    public List<AddressResponse> findAll() {
        List<Address> entity = gateway.findAll();

        return ObjectMapper.parseListObject(entity, AddressResponse.class);
    }

    @Override
    public AddressResponse create(AddressIncludeRequest request) {

        Address entity = ObjectMapper.parseObject(request, Address.class);

        Address client = gateway.create(entity);

        return ObjectMapper.parseObject(client, AddressResponse.class);
    }

    @Override
    public AddressResponse update(AddressChangesRequest request) {

        findById(request.getId());

        Address entity = ObjectMapper.parseObject(request, Address.class);

        Address client = gateway.update(entity);

        return ObjectMapper.parseObject(client, AddressResponse.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gateway.delete(id);
    }
}