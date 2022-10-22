package br.com.blinde.barberShop.interfaceadapter.domain.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressIncludeRequest {
    private String address;
    private String complementAddress;
    private String city;
    private String district;
    private String uf;
    private String zipCode;
}
