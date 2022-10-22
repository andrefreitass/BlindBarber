package br.com.blinde.barberShop.businessrule.usecase;

import br.com.blinde.barberShop.interfaceadapter.domain.request.address.AddressChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.address.AddressIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.AddressResponse;

import java.util.List;

public interface AddressUseCase {

    AddressResponse findById(Long id);

    List<AddressResponse> findAll();

    AddressResponse create(AddressIncludeRequest request);

    AddressResponse update(AddressChangesRequest request);

    void delete(Long id);
}
