package br.com.blinde.barbearia.interfaceadapter.domain.request.employee;

import br.com.blinde.barbearia.interfaceadapter.util.bean.Cpf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeChangesRequest implements Serializable {

    @NotNull
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 200)
    private String sobreNome;

    @NotBlank
    @Cpf
    private String cpf;

    @NotBlank
    @Pattern(regexp = "(\\d{2})/\\d{2}/\\d{4}$")
    private String dataNascimento;

    @NotBlank
    @Pattern(regexp = "(\\d{2})-\\d{5}-\\d{4}$")
    private String telefone;
}