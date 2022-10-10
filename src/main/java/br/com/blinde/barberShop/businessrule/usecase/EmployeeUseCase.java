package br.com.blinde.barberShop.businessrule.usecase;

import br.com.blinde.barberShop.interfaceadapter.domain.request.employee.EmployeeChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.employee.EmployeeIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeResponse;

import java.util.List;

public interface EmployeeUseCase {

    EmployeeResponse findById(Long id);

    List<EmployeeResponse> findAll();

    EmployeeResponse create(EmployeeIncludeRequest request);

    EmployeeResponse update(EmployeeChangesRequest request);

    void delete(Long id);

    EmployeeResponse findByCpf(String cpf);
}