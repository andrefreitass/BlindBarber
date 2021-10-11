package br.com.blinde.barbearia.entity;

import br.com.blinde.barbearia.enums.StatusAtendimentoEnums;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    private StatusAtendimentoEnums statusAtendimento;
}