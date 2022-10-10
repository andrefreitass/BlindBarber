package br.com.blinde.barberShop.interfaceadapter.domain.response;

import br.com.blinde.barberShop.interfaceadapter.enums.StatusSchedulingEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSchedulingResponse implements Serializable {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hour;

    private StatusSchedulingEnum status;

    private EmployeeResponse employee;
}