package br.com.blinde.barbearia.dto.request.cliente;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.dto.request.endereco.EnderecoIncluirRequest;
import br.com.blinde.barbearia.enums.SexoEnums;
import br.com.blinde.barbearia.uteis.beans.Cpf;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteIncluirRequest {

    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String sobreNome;

    @Cpf
    private String cpf;

    @NotBlank
    @Pattern(regexp = "(\\d{2})/\\d{2}/\\d{4}$")
    private String dataNascimento;

    @NotBlank
    @Pattern(regexp = "(\\d{3})-\\d{5}-\\d{4}$")
    private String telefone;

    @NotNull
    private Boolean possuiAgendamento;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAgendamento;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime horaAgendamento;

    @NotNull
    @Valid
    private EnderecoIncluirRequest endereco;

    @NotNull
    private SexoEnums sexo;
}
