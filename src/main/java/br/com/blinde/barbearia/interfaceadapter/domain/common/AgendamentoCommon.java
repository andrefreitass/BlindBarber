package br.com.blinde.barbearia.interfaceadapter.domain.common;

import br.com.blinde.barbearia.domain.Client;
import br.com.blinde.barbearia.domain.Employee;
import br.com.blinde.barbearia.interfaceadapter.enums.StatusAgendamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoCommon implements Serializable {

    private Long id;
    private Date data;
    private Date hora;
    private StatusAgendamentoEnum status;
    private Client client;
    private Employee employee;
}