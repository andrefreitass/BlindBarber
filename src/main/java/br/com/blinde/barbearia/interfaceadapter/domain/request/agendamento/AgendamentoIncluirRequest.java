package br.com.blinde.barbearia.interfaceadapter.domain.request.agendamento;

import br.com.blinde.barbearia.interfaceadapter.enums.StatusAgendamentoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoIncluirRequest implements Serializable {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hora;

    private StatusAgendamentoEnum status;
    private String clienteCpf;
    private String funcionarioCpf;
}