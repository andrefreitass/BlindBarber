package br.com.blinde.barbearia.dto.request.cliente;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.enums.SexoEnums;
import br.com.blinde.barbearia.uteis.beans.Cpf;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteAlterarRequest {

    @NotNull
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
    @Valid
    private EnderecoAlterarRequest endereco;

    @NotNull
    private SexoEnums sexo;
}