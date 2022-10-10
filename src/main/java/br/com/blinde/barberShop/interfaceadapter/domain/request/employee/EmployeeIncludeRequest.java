package br.com.blinde.barberShop.interfaceadapter.domain.request.employee;

import br.com.blinde.barberShop.interfaceadapter.enums.SexoEnums;
import br.com.blinde.barberShop.interfaceadapter.util.bean.Cpf;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeIncludeRequest implements Serializable {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String lastName;

    @Cpf
    @NotBlank
    private String cpf;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotBlank
    @Pattern(regexp = "(\\d{2})-\\d{5}-\\d{4}$")
    private String telephone;

    @NotNull
    private SexoEnums sex;
}