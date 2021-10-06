package br.com.blinde.barbearia.dto.response;

import br.com.blinde.barbearia.entity.Cliente;
import br.com.blinde.barbearia.enums.SexoEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private Boolean possuiAgendamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendamento;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaAgendamento;

    private EnderecoResponse endereco;
    private SexoEnums sexo;

    public ClienteResponse(Cliente cliente) {
       this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobreNome = cliente.getSobreNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.possuiAgendamento = cliente.getPossuiAgendamento();
        this.dataAgendamento = cliente.getDataAgendamento();
        this.horaAgendamento = cliente.getHoraAgendamento();
        this.endereco = new EnderecoResponse(cliente.getEndereco());
        this.sexo = cliente.getSexo();
    }
}
