package br.com.blinde.barberShop.interfaceadapter.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String address;
    private String complementAddress;
    private String city;
    private String district;
    private String uf;
    private String zipCode;
}