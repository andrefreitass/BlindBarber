package br.com.blinde.barbearia.interfaceadapter.domain.request.pagamento;

import br.com.blinde.barbearia.interfaceadapter.enums.FormaPagamento;
import br.com.blinde.barbearia.interfaceadapter.enums.Servico;
import br.com.blinde.barbearia.interfaceadapter.enums.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentIncludeRequest implements Serializable {

    private Servico servico;

    private FormaPagamento formaPagamento;

    private StatusPagamento statusPagamento;
}