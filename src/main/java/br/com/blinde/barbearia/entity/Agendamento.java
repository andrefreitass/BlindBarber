package br.com.blinde.barbearia.entity;

import br.com.blinde.barbearia.enums.StatusAtendimentoEnums;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    private StatusAtendimentoEnums statusAtendimento;
}