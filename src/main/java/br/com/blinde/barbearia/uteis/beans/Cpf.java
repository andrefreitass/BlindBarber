package br.com.blinde.barbearia.uteis.beans;

import br.com.blinde.barbearia.uteis.CpfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {

    String message() default "CPF Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
