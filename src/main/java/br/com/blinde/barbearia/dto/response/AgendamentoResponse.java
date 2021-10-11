package br.com.blinde.barbearia.dto.response;

import br.com.blinde.barbearia.entity.Agendamento;
import br.com.blinde.barbearia.entity.Cliente;
import br.com.blinde.barbearia.entity.Funcionario;
import br.com.blinde.barbearia.enums.StatusAtendimentoEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponse {

    private Long id;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime hora;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data;

    private StatusAtendimentoEnums statusAtendimento;
    private String clienteNome;
    private String clienteSobreNome;
    private String clienteTelefone;

    private String nomeFuncionario;

    public AgendamentoResponse(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getDataAgendamento();
        this.hora = agendamento.getHoraAgendamento();
        this.statusAtendimento = agendamento.getStatusAtendimento();
        this.clienteNome = agendamento.getCliente().getNome();
        this.clienteSobreNome = agendamento.getCliente().getSobreNome();
        this.clienteTelefone = agendamento.getCliente().getTelefone();
        this.nomeFuncionario = agendamento.getFuncionario().getNome();
    }
}
