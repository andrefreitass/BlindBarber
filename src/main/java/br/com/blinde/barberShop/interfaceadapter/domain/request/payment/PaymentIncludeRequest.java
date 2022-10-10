package br.com.blinde.barberShop.interfaceadapter.domain.request.payment;

import br.com.blinde.barberShop.interfaceadapter.enums.FormPayment;
import br.com.blinde.barberShop.interfaceadapter.enums.Service;
import br.com.blinde.barberShop.interfaceadapter.enums.StatusPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentIncludeRequest implements Serializable {

    private Service service;

    private FormPayment formPayment;

    private StatusPayment statusPayment;
}