package br.com.blinde.barberShop.domain.utils;

import br.com.blinde.barberShop.interfaceadapter.enums.SexoEnums;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalData implements Serializable {

    private String name;

    private String lastName;

    private String cpf;

    private LocalDate birthDate;

    private String telephone;

    @Enumerated(EnumType.STRING)
    private SexoEnums sex;
}
