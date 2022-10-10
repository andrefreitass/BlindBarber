package br.com.blinde.barberShop.interfaceadapter.domain.response;

import br.com.blinde.barberShop.interfaceadapter.enums.SexoEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private String telephone;
    private SexoEnums sex;
}