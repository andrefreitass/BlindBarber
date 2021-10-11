package br.com.blinde.barbearia.mapper;

import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoAlterarRequest;
import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoIncluirRequest;
import br.com.blinde.barbearia.dto.response.AgendamentoResponse;
import br.com.blinde.barbearia.entity.Agendamento;
import br.com.blinde.barbearia.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    private AgendamentoResponse response = new AgendamentoResponse();
    private Agendamento agendamento = new Agendamento();

    public Agendamento converterIncluirAgendamento(AgendamentoIncluirRequest source) {
        agendamento.setId(source.getId());
        agendamento.setDataAgendamento(source.getData());
        agendamento.setHoraAgendamento(source.getHora());
        agendamento.setCliente(source.getCliente());
        agendamento.setFuncionario(source.getFuncionario());
        agendamento.setStatusAtendimento(source.getStatusAtendimento());

        return agendamento;
    }

    public Agendamento converterAlterarAgendamento(AgendamentoAlterarRequest source) {
        agendamento.setId(source.getId());
        agendamento.setDataAgendamento(source.getData());
        agendamento.setHoraAgendamento(source.getHora());
        agendamento.setCliente(source.getCliente());
        agendamento.setFuncionario(source.getFuncionario());
        agendamento.setStatusAtendimento(source.getStatusAtendimento());

        return agendamento;
    }

    public AgendamentoResponse converterAgendamentoResponse(Agendamento source) {
        //response = new AgendamentoResponse(source.getCliente(),"tds",source);
        response = new AgendamentoResponse(source);
        /*
        *
        response.setId(source.getId());
        response.setData(source.getDataAgendamento());
        response.setHora(source.getHoraAgendamento());

        response.setCliente(source.getCliente());
        response.setFuncionario(source.getFuncionario());
        response.setStatusAtendimento(source.getStatusAtendimento());

         */

        return response;
    }

    public Page<AgendamentoResponse> converter(Page<Agendamento> agendamentoPage) {
        return agendamentoPage.map(AgendamentoResponse::new);
    }
}
