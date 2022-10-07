package br.com.trendy.girls.businessrule.exception.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {
    private Date timestamp;
    private String message;
    private String details;
}