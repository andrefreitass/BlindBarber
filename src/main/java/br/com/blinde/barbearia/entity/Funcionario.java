package br.com.blinde.barbearia.entity;

import br.com.blinde.barbearia.enums.SexoEnums;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private SexoEnums sexo;

}
