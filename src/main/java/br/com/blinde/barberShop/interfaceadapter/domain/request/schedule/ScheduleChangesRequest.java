package br.com.blinde.barberShop.interfaceadapter.domain.request.schedule;

import br.com.blinde.barberShop.interfaceadapter.enums.StatusSchedulingEnum;
import br.com.blinde.barberShop.interfaceadapter.util.bean.Cpf;
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
public class ScheduleChangesRequest implements Serializable {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hour;

    private StatusSchedulingEnum status;

    @Cpf
    private String clientCpf;

    @Cpf
    private String employeeCpf;
}