package br.com.blinde.barberShop.domain;

import br.com.blinde.barberShop.domain.utils.PersonalData;
import br.com.blinde.barberShop.interfaceadapter.enums.SexoEnums;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonalData personalData;

    public Client(String name, String lastName, String cpf, LocalDate birthDate, String telephone, SexoEnums sex) {
        this.personalData = new PersonalData(name,lastName,cpf,birthDate,telephone,sex);
    }
}