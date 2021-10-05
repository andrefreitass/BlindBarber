package br.com.blinde.barbearia.dto.request.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoAlterarRequest {

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 8, max = 10)
    @Pattern(regexp = "\\d{2}.\\d{3}-\\d{3}")
    private String cep;

    @NotBlank
    @Size(max = 150)
    private String logradouro;

    @NotBlank
    @Size(max = 200)
    private String complemento;

    @NotBlank
    @Size(max = 100)
    private String bairro;

    @NotBlank
    @Size(max = 60)
    private String localidade;

    @NotBlank
    @Size(min = 2, max = 2)
    private String uf;
}