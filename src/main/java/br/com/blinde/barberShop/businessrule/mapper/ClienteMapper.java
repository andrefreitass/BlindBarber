package br.com.blinde.barberShop.businessrule.mapper;

import br.com.blinde.barberShop.domain.Client;
import br.com.blinde.barberShop.interfaceadapter.domain.request.client.ClientChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.client.ClientIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "name", source = "personalData.name")
    @Mapping(target = "lastName", source = "personalData.lastName")
    @Mapping(target = "cpf", source = "personalData.cpf")
    @Mapping(target = "birthDate", source = "personalData.birthDate")
    @Mapping(target = "telephone", source = "personalData.telephone")
    @Mapping(target = "sex", source = "personalData.sex")
    ClientResponse clientFromClientResponse(Client client);

    @Mapping(target = "name", source = "personalData.name")
    @Mapping(target = "lastName", source = "personalData.lastName")
    @Mapping(target = "cpf", source = "personalData.cpf")
    @Mapping(target = "birthDate", source = "personalData.birthDate")
    @Mapping(target = "telephone", source = "personalData.telephone")
    @Mapping(target = "sex", source = "personalData.sex")
    List<ClientResponse> clientFromClientResponse(List<Client> client);

    @Mapping(target = "personalData.name", source = "name")
    @Mapping(target = "personalData.lastName", source = "lastName")
    @Mapping(target = "personalData.cpf", source = "cpf")
    @Mapping(target = "personalData.birthDate", source = "birthDate")
    @Mapping(target = "personalData.telephone", source = "telephone")
    @Mapping(target = "personalData.sex", source = "sex")
    Client clientIncludeRequestFromClient(ClientIncludeRequest clientIncludeRequest);

    @Mapping(target = "personalData.name", source = "name")
    @Mapping(target = "personalData.lastName", source = "lastName")
    @Mapping(target = "personalData.cpf", source = "cpf")
    @Mapping(target = "personalData.birthDate", source = "birthDate")
    @Mapping(target = "personalData.telephone", source = "telephone")
    @Mapping(target = "personalData.sex", source = "sex")
    Client clientChangesRequestFromClient(ClientChangesRequest clientChangesRequest);
}
