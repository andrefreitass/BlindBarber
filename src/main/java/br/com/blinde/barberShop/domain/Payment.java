package br.com.blinde.barberShop.domain;

import br.com.blinde.barberShop.interfaceadapter.enums.FormPayment;
import br.com.blinde.barberShop.interfaceadapter.enums.Service;
import br.com.blinde.barberShop.interfaceadapter.enums.StatusPayment;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Service service;

    @Enumerated(EnumType.STRING)
    private FormPayment formPayment;

    @Enumerated(EnumType.STRING)
    private StatusPayment statusPayment;
}