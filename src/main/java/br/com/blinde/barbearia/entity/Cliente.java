package br.com.blinde.barbearia.entity;

import br.com.blinde.barbearia.enums.SexoEnums;
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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobreNome;

    private String cpf;

    private String dataNascimento;

    private String telefone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private SexoEnums sexo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Agendamento agendamento;
}